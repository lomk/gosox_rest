package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.UserProfile;

public interface UserGenderRepository extends JpaRepository<UserProfile, Integer> {
}
