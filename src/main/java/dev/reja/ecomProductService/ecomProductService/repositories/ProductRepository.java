package dev.reja.ecomProductService.ecomProductService.repositories;

import dev.reja.ecomProductService.ecomProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    public Optional<List<Product>> findByCategoryId(UUID categoryId);
}
