package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
