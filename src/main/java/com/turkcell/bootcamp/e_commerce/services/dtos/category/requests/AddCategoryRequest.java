package com.turkcell.bootcamp.e_commerce.services.dtos.category.requests;

import com.turkcell.bootcamp.e_commerce.core.services.constants.Messages;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddCategoryRequest {
    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    @Length(min = 3, max = 50, message = Messages.ValidationErrors.VALIDATION_LENGTH)
    private String name;

    @Length(max = 255, message = Messages.ValidationErrors.VALIDATION_LENGTH)
    private String description;
}
