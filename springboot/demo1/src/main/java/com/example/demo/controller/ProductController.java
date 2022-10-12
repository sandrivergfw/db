package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductsMapper;
import com.example.demo.utils.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController  //组合注解 是GetMapping的基础
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductsMapper productsMapper;

    @GetMapping
    public List<Product> getAllProducts(){
        System.out.println(productsMapper.findAll().getClass().toString());
        return productsMapper.findAll();
    }

    @PostMapping("/selectBrand")
    public List<Product> selectByBrand(@RequestBody Filter filter){
        return productsMapper.selectByBrand(filter.getBrand());
    }

    @PostMapping("/selectPrice")
    public List<Product> selectByPrice(@RequestBody Filter filter){
        return productsMapper.selectByPrice(filter.getPrice1(), filter.getPrice2());
    }

    @PostMapping("/selectSize")
    public List<Product> selectBySize(@RequestBody Filter filter){
        return productsMapper.selectBySize(filter.getSize());
    }

    @PostMapping("/filter")
    public List<Product> selectFilter(@RequestBody Filter filter){
        System.out.println(filter.getPrice1());
        return productsMapper.selectFilter(filter);
    }
}
