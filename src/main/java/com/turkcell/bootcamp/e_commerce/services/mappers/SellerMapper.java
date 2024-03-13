package com.turkcell.bootcamp.e_commerce.services.mappers;

import com.turkcell.bootcamp.e_commerce.entities.Seller;
import com.turkcell.bootcamp.e_commerce.services.dtos.seller.requests.AddSellerRequest;
import org.mapstruct.factory.Mappers;

public interface SellerMapper {
    SellerMapper INSTANCE = Mappers.getMapper(SellerMapper.class);
    Seller sellerFromAddSellerRequest(AddSellerRequest request);
}
