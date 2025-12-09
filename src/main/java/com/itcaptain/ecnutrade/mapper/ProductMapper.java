package com.itcaptain.ecnutrade.mapper;

import com.itcaptain.ecnutrade.pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM product WHERE product_id = #{product_id}")
    Product selectProductById(Integer product_id);

    @Select(("SELECT * FROM product WHERE seller_id = #{seller_id}"))
    List<Product> selectProductBySellerId(Integer seller_id);

    @Delete("DELETE FROM product WHERE product_id = #{product_id}")
    void deleteProductById(Integer product_id);

    @Insert("INSERT into product(product_name,price,description,seller_id,picture,categories,campus,publishTime)"
            +"values(#{productName},#{price},#{description},#{sellerId},#{picture},#{categories},#{campus},now())")
    void publishProduct(Product product);

    @Select("SELECT * FROM product")
    List<Product> selectProduct();
}
