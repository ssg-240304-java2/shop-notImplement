package com.ohgiraffers.notimplement.product.model.dao;

import com.ohgiraffers.notimplement.product.model.domain.Product;
import com.ohgiraffers.notimplement.product.model.dto.CategoryResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    int allProductCount();

    int soldOutProductCount();

    List<Product> findAllProduct();

    void delete(long productId);

    void save(Product product);

    void update(Product product);

    List<CategoryResponse> findCategories();
}
