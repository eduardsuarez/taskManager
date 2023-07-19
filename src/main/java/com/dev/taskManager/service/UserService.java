/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.service;

import com.dev.taskManager.entity.User;
import com.dev.taskManager.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class UserService {

    
    private final UserRepository userRepository;
    
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    
    
    

    public User save(User user) {
        if (user.getId() == null) {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);
            return userRepository.save(user);
        } else {
            Optional<User> existingUser = userRepository.findUserById(user.getId());
            if (existingUser.isEmpty()) {
                if (!existEmail(user.getEmail())) {
                    String encryptedPassword1 = passwordEncoder.encode(user.getPassword());
                    user.setPassword(encryptedPassword1);
                    return userRepository.save(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }

    public boolean existEmail(String email) {
        return userRepository.existEmail(email);
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findUserById(id);
    }

    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public Page<User> findAllUsersPageable(Pageable pageable) {
        return userRepository.findAllUsersPageable(pageable);
    }

    public User updateUser(User user) {
        if (user.getId() != null) {
            Optional<User> userDb = userRepository.findUserById(user.getId());
            if (userDb.isPresent()) {
                if (user.getId() != null) {
                    userDb.get().setId(user.getId());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getLastName() != null) {
                    userDb.get().setLastName(user.getLastName());
                }
                userRepository.updateUser(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean deleteUserById(int userId) {
        Optional<User> user = getUserById(userId);
        if (user.isEmpty()) {
            return false;
        } else {
            userRepository.deleteUserById(user.get());
            return true;
        }
    }


    /*
    public User authenticateUser(String email, String password) {
        Optional<User> user = userRepository.authenticateUser(email, password);
        if (user.isEmpty()) {
            return new User();
        } else {
            return user.get();
        }

    }
     */
}
