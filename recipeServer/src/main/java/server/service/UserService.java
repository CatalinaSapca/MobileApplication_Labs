package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.model.User;
import server.repository.UserRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User find(String username, String password) {
        try {
            User user = userRepository.getOne(username);
            if (password.equals(user.getPassword()))
                return user;
        } catch (EntityNotFoundException exception) {
            return null;
        }
        return null;
    }
}
