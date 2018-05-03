package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.ProductGender;

public interface ProductGenderRepository extends JpaRepository<ProductGender, Integer> {
    ProductGender findByGenderName(String genderName);
}
