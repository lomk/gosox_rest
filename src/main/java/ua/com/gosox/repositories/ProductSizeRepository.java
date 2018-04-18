package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.ProductSize;

public interface ProductSizeRepository extends JpaRepository<ProductSize, Integer> {
}
