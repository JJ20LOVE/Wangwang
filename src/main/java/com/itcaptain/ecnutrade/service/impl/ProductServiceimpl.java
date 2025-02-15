package com.itcaptain.ecnutrade.service.impl;

import com.itcaptain.ecnutrade.mapper.ProductMapper;
import com.itcaptain.ecnutrade.pojo.Product;
import com.itcaptain.ecnutrade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceimpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product selectProductById(Integer product_id) {
        return productMapper.selectProductById(product_id);
    }
}
