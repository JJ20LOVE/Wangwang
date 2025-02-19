package com.itcaptain.ecnutrade.controller;

import com.itcaptain.ecnutrade.pojo.PageBean;
import com.itcaptain.ecnutrade.pojo.Product;
import com.itcaptain.ecnutrade.pojo.Result;
import com.itcaptain.ecnutrade.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class ProductController {
    private ProductService productService;
    @PostMapping("/publish")
    public Result add(@RequestBody Product product){
        productService.add(product);
        return Result.success();
    }
    @GetMapping
    public Result<PageBean<Product>> list(Integer pageNum,Integer pageSize,String name,
                                          @RequestParam(required = false) String state){
        PageBean<Product> pb=productService.list(pageNum,pageSize,name,state);
        return Result.success(pb);
    }
}
