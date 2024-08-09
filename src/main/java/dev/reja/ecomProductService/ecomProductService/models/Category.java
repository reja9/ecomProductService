package dev.reja.ecomProductService.ecomProductService.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Category extends BaseModel implements Serializable {

    private String categoryName;
}
