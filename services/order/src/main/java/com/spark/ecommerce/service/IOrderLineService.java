package com.spark.ecommerce.service;

import com.spark.ecommerce.dto.OrderLineRequest;
import com.spark.ecommerce.dto.OrderLineResponse;

import java.util.List;

public interface IOrderLineService {

    Integer saveOrderLine(OrderLineRequest orderLineRequest);

    List<OrderLineResponse> findAllByOrderId(Integer orderId);
}
