package dev.reja.ecomProductService.ecomProductService.controllers;

import dev.reja.ecomProductService.ecomProductService.dtos.CartItemDto;
import dev.reja.ecomProductService.ecomProductService.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/createCart")
    public ResponseEntity createCart(@RequestHeader ("Authorization")  String token, @RequestBody List<CartItemDto> cartItemDtoList){
        return ResponseEntity.ok(cartService.createCart(token,cartItemDtoList));
    }
}
