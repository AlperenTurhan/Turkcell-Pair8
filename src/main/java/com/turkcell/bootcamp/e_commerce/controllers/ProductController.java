package com.turkcell.bootcamp.e_commerce.controllers;

import com.turkcell.bootcamp.e_commerce.entities.Product;
import com.turkcell.bootcamp.e_commerce.services.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void add(@RequestBody Product product) throws Exception {
        productService.add(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws Exception {
        productService.delete(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody Product product) throws Exception {
        productService.update(product);
    }

    @GetMapping("/getall")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable(name = "id") int id) throws Exception {
        return productService.getById(id);
    }
}
