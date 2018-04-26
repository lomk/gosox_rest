package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.DeliveryType;

public interface DeliveryTypeRepository extends JpaRepository<DeliveryType, Integer> {
}
