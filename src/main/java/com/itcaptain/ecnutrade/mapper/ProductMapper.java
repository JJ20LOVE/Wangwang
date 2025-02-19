package com.itcaptain.ecnutrade.mapper;

import com.itcaptain.ecnutrade.pojo.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    //新增商品
    @Insert("insert into product(product_name,price,description,seller_id,buyer_id,picture,categories,product_state,campus)"
            +"values(#{productName},#{price},#{description},#{sellerId},#{buyerId},#{picture},#{categories},#{productState},#{campus})")
    void add(Product product);


    List<Product> list(Integer userId, String name, String state);
}
