package com.spark.ecommerce.service;

import com.spark.ecommerce.dto.ProductPurchaseRequest;
import com.spark.ecommerce.dto.ProductPurchaseResponse;
import com.spark.ecommerce.dto.ProductRequest;
import com.spark.ecommerce.dto.ProductResponse;

import java.util.ArrayList;
import java.util.List;

public interface IProductService {

    Integer createProduct(ProductRequest request);

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);

    ProductResponse findById(Integer productId);

    List<ProductResponse> findAll();
}
