package com.spark.ecommerce.repository;

import com.spark.ecommerce.dto.OrderLineResponse;
import com.spark.ecommerce.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    List<OrderLine> findAllByOrderId(Integer orderId);
}
