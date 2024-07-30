package dev.reja.ecomProductService.ecomProductService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Entity
@Getter
@Setter
public class Product extends BaseModel {

    private String productName;
    private double price;
    private String imageUrl;


    @ManyToOne

    private Category category;
}
