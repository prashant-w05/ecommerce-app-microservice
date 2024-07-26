package com.spark.ecommerce.util;

import com.spark.ecommerce.dto.OrderLineRequest;
import com.spark.ecommerce.dto.OrderLineResponse;
import com.spark.ecommerce.entity.Order;
import com.spark.ecommerce.entity.OrderLine;
import org.springframework.stereotype.Component;

@Component
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .id(orderLineRequest.id())
                .quantity(orderLineRequest.quantity())
                .order(Order.builder()
                        .id(orderLineRequest.orderId())
                        .build()
                )
                .productId(orderLineRequest.productId())
                .build();
    }

    public OrderLineResponse fromOrderLine(OrderLine orderLine) {
        return new OrderLineResponse(orderLine.getId(), orderLine.getQuantity());
    }
}
