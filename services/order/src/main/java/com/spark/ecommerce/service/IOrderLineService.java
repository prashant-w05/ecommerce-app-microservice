package com.spark.ecommerce.service;

import com.spark.ecommerce.dto.OrderLineRequest;

public interface IOrderLineService {

    Integer saveOrderLine(OrderLineRequest orderLineRequest);

}
