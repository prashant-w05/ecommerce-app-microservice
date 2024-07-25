package com.spark.ecommerce.product;

import com.spark.ecommerce.customer.CustomerResponse;
import com.spark.ecommerce.dto.PurchaseRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@FeignClient(
        name="customer-service",
        url="${application.config.product-url}"
)
public interface ProductClient {

    @GetMapping("/purchase")
    List<ProductResponse> purchaseProducts(List<PurchaseRequest> request);




}
