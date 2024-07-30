package dev.reja.ecomProductService.ecomProductService.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Cart extends BaseModel {
    private BigDecimal totalAmt;
}
