package com.spark.ecommerce.service.impl;

import com.spark.ecommerce.dto.OrderLineRequest;
import com.spark.ecommerce.dto.OrderLineResponse;
import com.spark.ecommerce.repository.OrderLineRepository;
import com.spark.ecommerce.service.IOrderLineService;
import com.spark.ecommerce.util.OrderLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderLineServiceImpl implements IOrderLineService {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private OrderLineMapper orderLineMapper;


    @Override
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var order = orderLineMapper.toOrderLine(orderLineRequest);
        return orderLineRepository.save(order).getId();
    }

    @Override
    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return orderLineRepository.findAllByOrderId(orderId)
                .stream()
                .map(orderLineMapper::fromOrderLine)
                .collect(Collectors.toList());
    }
}

