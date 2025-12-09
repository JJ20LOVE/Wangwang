package com.itcaptain.ecnutrade.service.impl;

import com.itcaptain.ecnutrade.mapper.ProductMapper;
import com.itcaptain.ecnutrade.pojo.Product;
import com.itcaptain.ecnutrade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceimpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product selectProductById(Integer product_id) {
        return productMapper.selectProductById(product_id);
    }

    @Override
    public List<Product> selectProductBySellerId(Integer seller_id) {
        return productMapper.selectProductBySellerId(seller_id);
    }

    @Override
    public void deleteProductById(Integer product_id) {
        productMapper.deleteProductById(product_id);
    }

   @Override
    public void publishProduct(Product product) {
        productMapper.publishProduct(product);
    }

    @Override
    public List<Product> selectProduct(){
        return productMapper.selectProduct();

    }
}
