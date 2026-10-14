package com.scaler.bmsseptevening2026.Services;

import com.scaler.bmsseptevening2026.Models.User;
import com.scaler.bmsseptevening2026.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User signup(String name, String email, String password){
        //TODO: Sign up logic
        // Check if user exists
        // Create a new user
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            throw new IllegalArgumentException("User already exists");
        }

        User u = new User();
        u.setName(name);
        u.setEmail(email);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        u.setPassword(passwordEncoder.encode(password));
        return userRepository.save(u);
    }
}
