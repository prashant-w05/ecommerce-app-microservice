package com.spark.ecommerce.service;

import com.spark.ecommerce.dto.PaymentRequest;

public interface IPaymentService {

    Integer createPayment(PaymentRequest request);
}
