package com.spark.ecommerce.service;

import com.spark.ecommerce.dto.OrderRequest;

public interface IOrderService {

    Integer createOrder(OrderRequest request);
}
