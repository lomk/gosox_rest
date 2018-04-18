package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
