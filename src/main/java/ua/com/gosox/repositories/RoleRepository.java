package ua.com.gosox.repositories;

import ua.com.gosox.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Igor on 29-Jun-16.
 */

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
