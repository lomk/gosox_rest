package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.ProductDetails;
import ua.com.gosox.domains.ProductMaterial;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {
}
