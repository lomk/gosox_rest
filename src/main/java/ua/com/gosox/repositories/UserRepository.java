package ua.com.gosox.repositories;


import ua.com.gosox.domains.Role;
import ua.com.gosox.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//import org.springframework.data.repository.CrudRepository;

/**
 * Created by Igor on 17-Jun-16.
 */
//@Repository
//@Transactional("adminTransactionManager")
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    List<User> findByRole(Role role);
}