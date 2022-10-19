package ro.sapca.recipeapp.repository.userRepo;

import java.util.ArrayList;
import java.util.List;

import ro.sapca.recipeapp.domain.User;

public class UserInMemoryRepository implements UserRepository {

    List<User> users = new ArrayList<>();

    public UserInMemoryRepository() {
        User user1 = new User("catalina", "password", "Catalina", "Sapca", "0098");
        User user2 = new User("test", "test", "UserTest", "TestUser", "0098");

        users.add(user1);
        users.add(user2);
    }

    @Override
    public User findUserByUsername(String username) {
        for (User user: users) {
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    @Override
    public Iterable<User> findAll() {
        return users;
    }

    @Override
    public boolean save(User user) {
        return users.add(user);
    }

    @Override
    public boolean delete(String username) {
        return users.removeIf(user->(user.getUsername().equals(username)));
    }

    @Override
    public boolean update(User user) {
        for (User u: users) {
            if(u.getUsername().equals(user.getUsername())) {
                u.setFirstName(user.getFirstName());
                u.setLastName(user.getLastName());
                u.setPhoneNumber(user.getPhoneNumber());
                u.setPassword(user.getPassword());
                return true;
            }
        }
        return false;
    }


}
