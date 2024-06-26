package com.ohgiraffers.notimplement.product.model.dao;

import com.ohgiraffers.notimplement.product.model.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ProductMapper {

    int allProductCount();

    int soldOutProductCount();

    List<Product> findAllProduct();
}
