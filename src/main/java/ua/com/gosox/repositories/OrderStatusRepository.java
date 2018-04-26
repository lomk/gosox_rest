package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
}
