package dev.reja.ecomProductService.ecomProductService.exceptions;

import dev.reja.ecomProductService.ecomProductService.controllers.ProductController;
import dev.reja.ecomProductService.ecomProductService.dtos.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity HandleProductNotFound(ProductNotFoundException e){

        ExceptionResponseDto exceptionResponseDto=new ExceptionResponseDto(e.getMessage(),404);
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RandomException.class)
    public ResponseEntity HandleRandomException(RandomException e){

        ExceptionResponseDto exceptionResponseDto=new ExceptionResponseDto(e.getMessage(),404);
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }
}
