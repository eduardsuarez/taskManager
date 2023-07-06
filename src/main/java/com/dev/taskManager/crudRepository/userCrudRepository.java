/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dev.taskManager.crudRepository;

import com.dev.taskManager.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author eduar
 */
public interface userCrudRepository extends JpaRepository<User, Integer>{
    public Optional<User> findByEmail(String email);
    public Optional<User> findByName(String name);

    /**
     *
     * @param email
     * @param password
     * @return

    public Optional<User> findByEmailAndPassword(String email, String password);
     */

}
