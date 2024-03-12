package com.turkcell.bootcamp.e_commerce.services.dtos.product.requests;

import com.turkcell.bootcamp.e_commerce.core.services.constants.Messages;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class AddProductRequest {
    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    @Length(min = 3, max = 50, message = Messages.ValidationErrors.VALIDATION_LENGTH)
    private String name;

    @Length(max = 255, message = Messages.ValidationErrors.VALIDATION_LENGTH)
    private String description;

    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    @Min(0)
    private int unitPrice;

    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    @Min(0)
    private int stock;

    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    @Min(0)
    private int categoryId;

    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    @Min(0)
    private int sellerId;
}
