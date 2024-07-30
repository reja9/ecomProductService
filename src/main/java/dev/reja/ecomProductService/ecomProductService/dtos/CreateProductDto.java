package dev.reja.ecomProductService.ecomProductService.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class CreateProductDto {


    private String productName;
    private double price;
    private String imageUrl;

    private UUID categoryId;
}
