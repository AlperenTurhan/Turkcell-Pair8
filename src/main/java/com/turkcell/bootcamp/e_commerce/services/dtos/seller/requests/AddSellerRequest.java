package com.turkcell.bootcamp.e_commerce.services.dtos.seller.requests;

import com.turkcell.bootcamp.e_commerce.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddSellerRequest {
    private String taxNumber;
    private int userId;
    private List<Product> products;
}