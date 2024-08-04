package dev.reja.ecomProductService.ecomProductService.services;

import dev.reja.ecomProductService.ecomProductService.dtos.CartItemDto;
import dev.reja.ecomProductService.ecomProductService.models.Cart;

import java.util.List;

public interface CartService {
    public Cart createCart(String token, List<CartItemDto>  cartItemDtoList);
}
