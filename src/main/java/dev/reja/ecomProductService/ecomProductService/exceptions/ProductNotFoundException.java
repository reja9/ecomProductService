package dev.reja.ecomProductService.ecomProductService.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public  ProductNotFoundException(String message){
        super(message);
    }
}
