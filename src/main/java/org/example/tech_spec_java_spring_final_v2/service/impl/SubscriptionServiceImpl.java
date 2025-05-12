package org.example.tech_spec_java_spring_final_v2.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.tech_spec_java_spring_final_v2.entity.Subscription;
import org.example.tech_spec_java_spring_final_v2.entity.User;
import org.example.tech_spec_java_spring_final_v2.repository.SubscriptionRepository;
import org.example.tech_spec_java_spring_final_v2.repository.UserRepository;
import org.example.tech_spec_java_spring_final_v2.service.SubscriptionService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    @Override
    public Subscription addSubscription(Long userId, String serviceName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Subscription subscription = new Subscription();
        subscription.setServiceName(serviceName);
        subscription.setUser(user);

        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> getSubscriptionByUserId(Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }

    @Override
    public void deleteSubscription(Long userId, Long subscriptionId) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        if (!subscription.getUser().getId().equals(userId)) {
            throw new RuntimeException("Subscription does not belong to this user");
        }

        subscriptionRepository.delete(subscription);
    }

    @Override
    public List<String> getTop3Subscriptions() {

        return subscriptionRepository.findTop3PopularSubscriptions();

    }
}
