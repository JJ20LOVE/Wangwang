package com.itcaptain.ecnutrade.service;

import com.itcaptain.ecnutrade.pojo.PageBean;
import com.itcaptain.ecnutrade.pojo.Product;

public interface ProductService {
    //新增商品
    void add(Product product);

    //条件分页列表查询
    PageBean<Product> list(Integer pageNum, Integer pageSize, String name, String state);
}
