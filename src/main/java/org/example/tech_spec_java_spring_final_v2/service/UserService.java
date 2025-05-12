package org.example.tech_spec_java_spring_final_v2.service;


import org.example.tech_spec_java_spring_final_v2.entity.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    User updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
}
