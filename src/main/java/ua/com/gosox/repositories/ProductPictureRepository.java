package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.ProductPicture;

public interface ProductPictureRepository extends JpaRepository<ProductPicture, Integer> {
}
