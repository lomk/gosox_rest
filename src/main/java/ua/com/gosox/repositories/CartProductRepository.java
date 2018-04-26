package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.CartProduct;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {
}
