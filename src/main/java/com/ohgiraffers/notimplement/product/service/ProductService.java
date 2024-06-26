package com.ohgiraffers.notimplement.product.service;

import com.ohgiraffers.notimplement.product.model.dao.ProductMapper;
import com.ohgiraffers.notimplement.product.model.domain.Product;
import com.ohgiraffers.notimplement.product.model.dto.DashboardResponse;
import com.ohgiraffers.notimplement.product.model.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public DashboardResponse showDashboard() {
        int allProductCount = productMapper.allProductCount();
        int soldOutProductCount = productMapper.soldOutProductCount();
        return new DashboardResponse(allProductCount, soldOutProductCount, allProductCount - soldOutProductCount);
    }

    public List<ProductResponse> findAllProduct() {
        return productMapper.findAllProduct()
                .stream()
                .map(ProductResponse::from)
                .toList();
    }

    public void delete(long productId) {
        productMapper.delete(productId);
    }
}
