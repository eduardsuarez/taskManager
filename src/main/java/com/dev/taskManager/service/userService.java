/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.service;
import com.dev.taskManager.entity.User;
import com.dev.taskManager.repository.userRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class userService {
    @Autowired
    private userRepository userRepository;

    public User save(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> e = userRepository.findUserById(user.getId());
            if (e.isEmpty()) {
                if (existEmail(user.getEmail()) == false) {
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
            if (!userDb.isEmpty()) {
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
    
   
    
}
