package com.itcaptain.ecnutrade.mapper;

import com.itcaptain.ecnutrade.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM product WHERE product_id = #{product_id}")
    Product selectProductById(Integer product_id);
}
