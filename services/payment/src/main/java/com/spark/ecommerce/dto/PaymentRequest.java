package com.spark.ecommerce.dto;

import com.spark.ecommerce.customer.Customer;
import com.spark.ecommerce.util.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
