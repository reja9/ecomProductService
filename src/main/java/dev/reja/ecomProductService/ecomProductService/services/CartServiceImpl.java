package dev.reja.ecomProductService.ecomProductService.services;

import dev.reja.ecomProductService.ecomProductService.dtos.CartItemDto;
import dev.reja.ecomProductService.ecomProductService.dtos.CreateOrderDto;
import dev.reja.ecomProductService.ecomProductService.models.Cart;
import dev.reja.ecomProductService.ecomProductService.models.Product;
import dev.reja.ecomProductService.ecomProductService.repositories.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;


@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Value("${create.order.url}")
    private String createOrderUrl;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Cart createCart(String token, List<CartItemDto> cartItemDtoList) {
        log.info("going into createCart method");
        BigDecimal totalAmt=new BigDecimal(0);
        Cart cart=new Cart();
        for(CartItemDto cartItemDto : cartItemDtoList){
            Product product=productService.getProductById(cartItemDto.getProductId());
            totalAmt=totalAmt.add(BigDecimal.valueOf(cartItemDto.getQuantity()*product.getPrice()));
        }
        cart.setTotalAmt(totalAmt);
        cart=cartRepository.save(cart);
        //now from this cart we are hitting order service api for creating order
        CreateOrderDto createOrderDto=new CreateOrderDto();
        createOrderDto.setToken(token);
        createOrderDto.setCartId(cart.getId());
        createOrderDto.setTotalAmt(cart.getTotalAmt());

        HttpHeaders headers=new HttpHeaders();
        headers.add("Authorization", token);
        HttpEntity<CreateOrderDto> entity = new HttpEntity<CreateOrderDto>(createOrderDto, headers);

        log.info("the order service url for creating order is - "+createOrderUrl);
        String response=restTemplate.exchange(createOrderUrl, HttpMethod.POST,entity,String.class).getBody();
        log.info("Response for create order is "+response);
        log.info("ends of createCart method ");
        return cart;
    }
}
