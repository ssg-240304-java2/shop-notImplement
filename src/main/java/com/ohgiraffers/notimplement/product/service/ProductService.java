package com.ohgiraffers.notimplement.product.service;

import com.ohgiraffers.notimplement.product.model.dao.ProductMapper;
import com.ohgiraffers.notimplement.product.model.dto.DashBoardResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    public DashBoardResponse showDashboard() {
        int allProductCount = productMapper.allProductCount();
        int soldOutProductCount = productMapper.soldOutProductCount();

        return new DashBoardResponse(allProductCount, soldOutProductCount);
    }
}
