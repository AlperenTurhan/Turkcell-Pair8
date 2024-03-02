package com.turkcell.bootcamp.e_commerce.repositories.concretes;

import com.turkcell.bootcamp.e_commerce.entities.Product;
import com.turkcell.bootcamp.e_commerce.repositories.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    List<Product> products;

    public ProductRepositoryImpl(){
        products = new ArrayList<Product>();
    }
    @Override
    public void add(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

    @Override
    public void delete(int id) {
        products.remove(getById(id));
        System.out.println("Product deleted: " + id);
    }

    @Override
    public void update(Product product) {
        Product oldProduct = getById(product.getId());
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setStock(product.getStock());
        oldProduct.setCategoryId(product.getCategoryId());
        oldProduct.setDescription(product.getDescription());
        System.out.println("Product updated: " + product.getName());
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        for(Product product: products){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }
}
