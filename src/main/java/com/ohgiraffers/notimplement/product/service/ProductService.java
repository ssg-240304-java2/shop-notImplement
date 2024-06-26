package com.ohgiraffers.notimplement.product.service;

import com.ohgiraffers.notimplement.product.model.dao.ProductMapper;
import com.ohgiraffers.notimplement.product.model.dto.CategoryResponse;
import com.ohgiraffers.notimplement.product.model.dto.DashboardResponse;
import com.ohgiraffers.notimplement.product.model.dto.ProductRequest;
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

    public void saveProduct(ProductRequest productRequest) {
        productMapper.save(productRequest.toEntity());
    }

    public void update(ProductRequest productRequest) {
        productMapper.update(productRequest.toEntity());
    }

    public List<CategoryResponse> getCategories() {
        return productMapper.findCategories();
    }

//    public List<ProductResponse> findUserProduct() {
//        return productMapper.findUserProduct()
//                .stream()
//                .map(product -> ProductResponse.from(product))
//                .toList();

//    }
}
