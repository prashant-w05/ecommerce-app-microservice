package com.spark.ecommerce.service.impl;

import com.spark.ecommerce.dto.PaymentRequest;
import com.spark.ecommerce.notification.NotificationProducer;
import com.spark.ecommerce.notification.PaymentNotificationRequest;
import com.spark.ecommerce.repository.PaymentRepository;
import com.spark.ecommerce.service.IPaymentService;
import com.spark.ecommerce.util.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private PaymentMapper mapper;

    @Autowired
    private NotificationProducer notificationProducer;

    @Override
    public Integer createPayment(PaymentRequest request) {
        var payment = this.repository.save(this.mapper.toPayment(request));

        this.notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }
}
