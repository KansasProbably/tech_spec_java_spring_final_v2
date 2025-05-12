package org.example.tech_spec_java_spring_final_v2.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.tech_spec_java_spring_final_v2.entity.User;
import org.example.tech_spec_java_spring_final_v2.repository.UserRepository;
import org.example.tech_spec_java_spring_final_v2.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        log.info("creating user with name: {}", user.getName());
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            log.info("Error occurred while creating user with name: {}", user.getName(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserById(Long id) {
        log.info("Fetching user with ID: {}", id);
        User user =  userRepository.findById(id)
                .orElseThrow(() -> {log.info("User with ID: {} not found", id);
                    return new RuntimeException("User not found");
                });
        log.info("Successfully fetched user with ID: {}", id);
        return user;
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        log.info("Updating user with ID: {}", id);
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            user.setName(user.getName());
            user.setEmail(user.getEmail());
            User savedUser = userRepository.save(user);
            log.info("User with ID: {} updated successfully", savedUser.getId());
            return savedUser;
        } catch (Exception e) {
            log.info("Error occurred while updating user with ID: {}", id, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(Long id) {
        log.info("Deleting user with ID: {}", id);
        try {
            userRepository.deleteById(id);
            log.info("User with ID: {} deleted successfully", id);
        } catch (Exception e) {
            log.info("Error occurred while deleting user with ID: {}", id, e);
            throw new RuntimeException(e);
        }
        }
}
