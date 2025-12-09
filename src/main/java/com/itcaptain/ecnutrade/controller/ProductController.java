package com.itcaptain.ecnutrade.controller;

import com.itcaptain.ecnutrade.pojo.Product;
import com.itcaptain.ecnutrade.pojo.User;
import com.itcaptain.ecnutrade.pojo.Result;
import com.itcaptain.ecnutrade.service.ProductService;

import com.itcaptain.ecnutrade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("/product")
public class   ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;


//    public Result selectProductById(int productId) {
//        //Product product = ProductService.selectProductById(productId);
//        Product product = productService.selectProductById(productId);
//        if(product == null){
//            return Result.success(product);
//        }else{
//            return Result.error(0,null);
//        }
//    }

    @GetMapping("/productDetail")
    public ProductDetailResponse getProductDetailWithSeller(Integer product_id) {
        Product product = productService.selectProductById(product_id);
        if (product == null) {

            return new ProductDetailResponse(null, null);
        }
        int sellerId = product.getSellerId();
        User seller = userService.selectUserById(sellerId);
        return new ProductDetailResponse(product, seller);
    }

    @GetMapping("/myProduct")
    public List<Product> selectProductBySeller(Integer seller_id) {
        return productService.selectProductBySellerId(seller_id);
    }

    @GetMapping("/deleteProduct")
    public Result deleteProductById(Integer product_id){
        productService.deleteProductById(product_id);
        return Result.success(null);
    }

    @PostMapping("/publish")
    public Result publishProduct(@RequestBody Product product){
        productService.publishProduct(product);
        return Result.success(null);
    }

    @GetMapping("/list")
    public List<Product> list(){
       return productService.selectProduct();
    }

}


class ProductDetailResponse {
    private Product product;
    private User seller;

    public ProductDetailResponse(Product product, User seller) {
        this.product = product;
        this.seller = seller;
    }

    public Product getProduct() {
        return product;
    }

    public User getSeller() {
        return seller;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}


