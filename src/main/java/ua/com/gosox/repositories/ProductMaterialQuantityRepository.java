package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.ProductMaterialQuantity;

public interface ProductMaterialQuantityRepository extends JpaRepository<ProductMaterialQuantity, Integer> {
}
