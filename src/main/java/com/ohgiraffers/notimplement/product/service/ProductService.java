package com.ohgiraffers.notimplement.product.service;

import com.ohgiraffers.notimplement.product.model.dao.ProductMapper;
import com.ohgiraffers.notimplement.product.model.domain.Product;
import com.ohgiraffers.notimplement.product.model.dto.*;
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

    public void saveProduct(ProductCreateRequest request) {
        productMapper.save(request.toEntity());
    }

    public void update(int productId, ProductUpdateRequest request) {
        Product product = productMapper.findById(productId)
                .orElseThrow(() -> new IllegalStateException("상품을 찾지 못했습니다. - " + productId));
        product.update(request);
        productMapper.update(product);
    }

    public List<CategoryResponse> getCategories() {
        return productMapper.findCategories();
    }

    public ProductResponse getById(int productId) {
        return productMapper.findById(productId)
                .map(ProductResponse::from)
                .orElseThrow(() -> new IllegalStateException("상품을 찾지 못했습니다. - " + productId));
    }
}
