package com.itcaptain.ecnutrade.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itcaptain.ecnutrade.mapper.ProductMapper;
import com.itcaptain.ecnutrade.pojo.PageBean;
import com.itcaptain.ecnutrade.pojo.Product;
import com.itcaptain.ecnutrade.service.ProductService;
import com.itcaptain.ecnutrade.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public void add(Product product) {
        //补充属性值
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userId=(Integer)map.get("userId");
        product.setSellerId(userId);
        productMapper.add(product);
    }

    @Override
    public PageBean<Product> list(Integer pageNum, Integer pageSize, String name, String state) {
        //1.创建PageBean对象
       PageBean<Product> pb=new PageBean<>();
       //2.开启分页查询PageHelper
        PageHelper.startPage(pageNum,pageSize);
        //3.调用mapper查询数据
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userId=(Integer)map.get("userId");
        List<Product> as= productMapper.list(userId,name,state);
        Page<Product> p=(Page<Product>) as;
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}
 