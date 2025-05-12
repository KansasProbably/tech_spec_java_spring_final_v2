package org.example.tech_spec_java_spring_final_v2.repository;

import org.example.tech_spec_java_spring_final_v2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
