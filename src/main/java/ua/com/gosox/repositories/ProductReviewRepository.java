package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {
}
