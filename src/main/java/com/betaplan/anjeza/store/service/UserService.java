package com.betaplan.anjeza.store.service;

import com.betaplan.anjeza.store.model.LoginUser;
import com.betaplan.anjeza.store.model.User;
import com.betaplan.anjeza.store.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateAndRegister(User user, BindingResult result) {
        // check if email is already registered
        if (userRepository.findUserByEmail(user.getEmail()).isPresent()) {
            result.rejectValue("email", "error.user", "This email is already in use.");
        }

        // Save user only if no errors
        if (!result.hasErrors()) {
            // Hash the password and save to the database
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            userRepository.save(user);
        }
    }

    public User login(LoginUser loginUser, BindingResult result) {
        // Fetch user by email
        User user = userRepository.findUserByEmail(loginUser.getEmail()).orElse(null);

        if (user == null || !BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
            result.rejectValue("email", "error.loginUser", "Invalid email or password.");
            return null;
        }

        return user;
    }

    public User getUserById (Integer id) {
        return userRepository.getById(id);
    }

}
