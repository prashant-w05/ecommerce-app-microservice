package com.spark.ecommerce.kafka;

import com.spark.ecommerce.customer.CustomerResponse;
import com.spark.ecommerce.product.ProductResponse;
import com.spark.ecommerce.util.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderRefernece,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<ProductResponse> products
) {
}
