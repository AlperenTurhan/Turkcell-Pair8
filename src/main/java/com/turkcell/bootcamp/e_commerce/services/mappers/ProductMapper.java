package com.turkcell.bootcamp.e_commerce.services.mappers;

import com.turkcell.bootcamp.e_commerce.services.dtos.product.requests.AddProductRequest;
import com.turkcell.bootcamp.e_commerce.entities.Product;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "sellerId", target = "seller.id")
    Product productFromAddProductRequest(AddProductRequest request);
}
