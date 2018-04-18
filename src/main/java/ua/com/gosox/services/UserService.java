package ua.com.gosox.services;


import ua.com.gosox.domains.User;

/**
 * Created by Igor on 17-Jun-16.
 */
public interface UserService {
    Iterable<User> listAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
    void save(User user);
    public User findByUsername(String username);
}
