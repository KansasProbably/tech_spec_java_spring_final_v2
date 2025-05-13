package org.example.tech_spec_java_spring_final_v2.repository;

import org.example.tech_spec_java_spring_final_v2.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    List<Subscription> findByUserId(Long userId);

    @Query(value = "SELECT s.service_name " +
                   "FROM subscriptions s " +
                   "JOIN users u ON s.user_id = u.id " +
                   "GROUP BY s.service_name " +
                   "ORDER BY COUNT(u.id) DESC " +
                   "LIMIT 3", nativeQuery = true)
    List<String> findTop3PopularSubscriptions();
}
