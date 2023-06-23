/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.repository;

import com.dev.taskManager.crudRepository.userCrudRepository;
import com.dev.taskManager.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduar
 */
@Repository
public class userRepository {
    @Autowired
    private userCrudRepository userCrudRepository;

    public User save(User user) {
        return userCrudRepository.save(user);
    }
    
    public Optional<User> findUserById(int id) {
        return userCrudRepository.findById(id);
    }
    
    public Boolean existEmail(String email) {
        Optional<User> user = (Optional<User>) userCrudRepository.findByEmail(email);
        boolean b = !user.isEmpty();
        return b;
    }
    
    public Optional<User> findByName(String name) {
        return userCrudRepository.findByName(name);
    }


    public List<User> findAllUsers() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Page<User> findAllUsersPageable(Pageable pageable) {
        return userCrudRepository.findAll(pageable);
    }

    public User updateUser(User user) {
        return userCrudRepository.save(user);
    }
    public void deleteUserById(User user) {
        userCrudRepository.delete(user);

    }
    
}
