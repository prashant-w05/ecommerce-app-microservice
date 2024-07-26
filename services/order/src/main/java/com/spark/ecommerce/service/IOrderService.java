package com.spark.ecommerce.service;

import com.spark.ecommerce.dto.OrderRequest;
import com.spark.ecommerce.dto.OrderResponse;

import java.util.List;

public interface IOrderService {

    Integer createOrder(OrderRequest request);

    List<OrderResponse> findAll();

    OrderResponse findById(Integer orderId);
}
