package com.turkcell.bootcamp.e_commerce.services.dtos.product.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductListResponse {
    private int id;
    private String name;
    private String categoryName;
    private int unitPrice;
}