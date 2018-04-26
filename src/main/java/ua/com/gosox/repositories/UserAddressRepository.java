package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {
}
