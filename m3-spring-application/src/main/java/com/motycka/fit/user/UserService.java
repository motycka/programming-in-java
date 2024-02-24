package com.motycka.fit.user;

import com.motycka.fit.user.model.User;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<User> getUsers() {
        return userRepository.selectAll();
    }

    User getUserById(Long id) {
        return userRepository.selectById(id);
    }

    User createUser(User user) {
        String token = Base64.getEncoder().encodeToString(user.name().getBytes());
        return userRepository.insert(user, token);
    }

    User updateUser(User user) {
        return userRepository.update(user);
    }

    void deleteUser(Long id) {
        // TODO delete also all activities?
        userRepository.delete(id);
    }
}
