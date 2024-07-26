package com.spark.ecommerce.payment;

import com.spark.ecommerce.customer.CustomerResponse;
import com.spark.ecommerce.util.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(

        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer

) {
}
