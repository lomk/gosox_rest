package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.OrderedProduct;

public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Integer> {
}
