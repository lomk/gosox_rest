package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.ProductBrand;

public interface ProductBrandRepository extends JpaRepository<ProductBrand, Integer> {
}
