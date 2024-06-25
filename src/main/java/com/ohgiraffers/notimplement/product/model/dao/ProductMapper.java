package com.ohgiraffers.notimplement.product.model.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    int allProductCount();

    int soldOutProductCount();
}
