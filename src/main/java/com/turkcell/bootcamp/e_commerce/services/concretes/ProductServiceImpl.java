package com.turkcell.bootcamp.e_commerce.services.concretes;

import com.turkcell.bootcamp.e_commerce.core.exception.types.BusinessException;
import com.turkcell.bootcamp.e_commerce.core.services.abstracts.MessageService;
import com.turkcell.bootcamp.e_commerce.core.services.constants.Messages;
import com.turkcell.bootcamp.e_commerce.entities.Product;
import com.turkcell.bootcamp.e_commerce.repositories.abstracts.ProductRepository;
import com.turkcell.bootcamp.e_commerce.services.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ResourceBundleMessageSource bundleMessageSource;
    private  ProductRepository productRepository;
    private MessageService messageService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public void add(Product product) throws Exception {
        if(isIdExist(product.getId())){
            throw new Exception("This product already exists.");
        }
        productRepository.save(product);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such a product");
        }
        productRepository.deleteById(id);
    }

    public int productAmountByCategoryName(String name){
        return productRepository.countProductsByCategoryName(name);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
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

    private void productsWithSameNameShouldNotExist(String name){
        Optional<Product> productWithSameName = productRepository.findByName(name);
        if (productWithSameName.isPresent()){
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.SAME_PRODUCT_NAME_ERROR, name));
        }
    }
}
