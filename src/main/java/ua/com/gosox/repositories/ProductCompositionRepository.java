package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.ProductComposition;

public interface ProductCompositionRepository extends JpaRepository<ProductComposition, Integer> {
}
