package dev.reja.ecomProductService.ecomProductService.services;

import dev.reja.ecomProductService.ecomProductService.dtos.CartItemDto;
import dev.reja.ecomProductService.ecomProductService.models.Cart;
import dev.reja.ecomProductService.ecomProductService.models.Product;
import dev.reja.ecomProductService.ecomProductService.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private ProductService productService;
    @Autowired
    private CartRepository cartRepository;
    @Override
    public Cart createCart(List<CartItemDto> cartItemDtoList) {
        BigDecimal totalAmt=new BigDecimal(0);
        Cart cart=new Cart();
        for(CartItemDto cartItemDto : cartItemDtoList){
            Product product=productService.getProductById(cartItemDto.getProductId());
            totalAmt=totalAmt.add(BigDecimal.valueOf(cartItemDto.getQuantity()*product.getPrice()));
        }
        cart.setTotalAmt(totalAmt);
        cartRepository.save(cart);
        //now from this cart we are hitting order service api for creating order
        return cart;
    }
}
