package com.ecommerce.ecommerce.feature.product.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequestDto {

    @NotBlank(message = "Category Name cannot be null or empty")
    @NotNull(message = "Category Name cannot be null or empty")
    private String categoryName;

    @NotBlank(message = "Category Image cannot be null or empty")
    @NotNull(message = "Category Image cannot be null or empty")
    private String categoryImage;

    @NotBlank(message = "Description cannot be null or empty")
    @NotNull(message = "Description cannot be null or empty")
    private String description;
}
