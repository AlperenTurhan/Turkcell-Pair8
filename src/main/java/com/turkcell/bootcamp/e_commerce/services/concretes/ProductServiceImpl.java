package com.turkcell.bootcamp.e_commerce.services.concretes;

import com.turkcell.bootcamp.e_commerce.core.exception.types.BusinessException;
import com.turkcell.bootcamp.e_commerce.core.services.abstracts.MessageService;
import com.turkcell.bootcamp.e_commerce.core.services.constants.Messages;
import com.turkcell.bootcamp.e_commerce.entities.Category;
import com.turkcell.bootcamp.e_commerce.entities.Product;
import com.turkcell.bootcamp.e_commerce.repositories.ProductRepository;
import com.turkcell.bootcamp.e_commerce.services.abstracts.ProductService;
import com.turkcell.bootcamp.e_commerce.services.dtos.product.requests.AddProductRequest;
import com.turkcell.bootcamp.e_commerce.services.dtos.product.responses.ProductListResponse;
import com.turkcell.bootcamp.e_commerce.services.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private  ProductRepository productRepository;
    private MessageService messageService;

    @Override
    public void add(AddProductRequest request) throws Exception {
        productsWithSameNameShouldNotExist(request.getName());

        Category category = new Category();
        category.setId(request.getCategoryId());

        Product product = ProductMapper.INSTANCE.productFromAddProductRequest(request);
        product.setCategory(category);
        productRepository.save(product);
    }

    @Override
    public void delete(int id) throws Exception {
        if (isIdExist(id)) {
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.NOT_FOUND_ERROR, id));
        }
        productRepository.deleteById(id);
    }

    public int productAmountByCategoryName(String name){
        return productRepository.countProductsByCategoryName(name);
    }

    @Override
    public List<ProductListResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductListResponse> response = new ArrayList<>();

        for (Product product: products) {
            ProductListResponse dto = new ProductListResponse(
                    product.getId(),
                    product.getName(),
                    product.getCategory().getName(),
                    product.getUnitPrice());
            response.add(dto);
        }

        return response;
    }

    @Override
    public Product getById(int id) throws Exception {
        if (isIdExist(id)) {
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.NOT_FOUND_ERROR, id));
        }
        return productRepository.findById(id).get();
    }

    public boolean isIdExist(int id) {
        return productRepository.existsById(id);
    }

    private void productsWithSameNameShouldNotExist(String name){
        Optional<Product> productWithSameName = productRepository.findByName(name);
        if (productWithSameName.isPresent()){
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.SAME_PRODUCT_NAME_ERROR, name));
        }
    }

}
