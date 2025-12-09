package com.itcaptain.ecnutrade.service;

import com.itcaptain.ecnutrade.pojo.Product;

import java.util.List;

public interface ProductService {
     Product selectProductById(Integer product_id);

     List<Product> selectProductBySellerId(Integer seller_id);

     void deleteProductById(Integer product_id);

     void publishProduct(Product product);


     List<Product> selectProduct();
}
