package dev.reja.ecomProductService.ecomProductService.repositories;

import dev.reja.ecomProductService.ecomProductService.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {
}
