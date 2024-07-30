package dev.reja.ecomProductService.ecomProductService.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public  CategoryNotFoundException(String message){
        super(message);
    }
}
