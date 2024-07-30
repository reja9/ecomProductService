package dev.reja.ecomProductService.ecomProductService.dtos;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public class ResponseDto extends ResponseEntity implements Serializable {
    public ResponseDto(HttpStatusCode status) {
        super(status);
    }
}
