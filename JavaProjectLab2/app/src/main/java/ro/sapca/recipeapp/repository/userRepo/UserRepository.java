package ro.sapca.recipeapp.repository.userRepo;

import java.sql.SQLException;

import ro.sapca.recipeapp.domain.User;

public interface UserRepository {

    User findUserByUsername(String username);
    Iterable<User> findAll();
    boolean save(User user);
    boolean delete(String username);
    boolean update(User user);
}
