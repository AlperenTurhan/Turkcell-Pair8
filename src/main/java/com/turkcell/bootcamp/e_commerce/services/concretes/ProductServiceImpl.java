package com.turkcell.bootcamp.e_commerce.services.concretes;

import com.turkcell.bootcamp.e_commerce.entities.Product;
import com.turkcell.bootcamp.e_commerce.repositories.abstracts.ProductRepository;
import com.turkcell.bootcamp.e_commerce.services.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public void add(Product product) throws Exception {
        if(isIdExist(product.getId())){
            throw new Exception("This product already exists.");
        }
        productRepository.add(product);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such a product");
        }
        productRepository.delete(id);
    }

    @Override
    public void update(Product product) throws Exception {
        if (!isIdExist(product.getId())) {
            throw new Exception("There is no such a product");
        }
        productRepository.update(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product getById(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such a product");
        }
        return productRepository.getById(id);
    }

    public boolean isIdExist(int id) {
        for (Product product : getAll()) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
