package ua.com.gosox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.gosox.domains.City;

public interface CityRepository extends JpaRepository<City, Integer> {
}
