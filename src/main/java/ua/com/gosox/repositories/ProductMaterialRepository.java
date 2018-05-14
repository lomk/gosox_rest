package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.ProductMaterial;

public interface ProductMaterialRepository extends JpaRepository<ProductMaterial, Integer> {
    ProductMaterial findByName(String name);
}
