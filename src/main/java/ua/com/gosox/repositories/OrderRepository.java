package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
