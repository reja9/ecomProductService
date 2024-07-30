package dev.reja.ecomProductService.ecomProductService.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CartItemDto {
    private UUID productId;
    private Long quantity;

}
