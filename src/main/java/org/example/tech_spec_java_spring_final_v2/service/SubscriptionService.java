package org.example.tech_spec_java_spring_final_v2.service;


import org.example.tech_spec_java_spring_final_v2.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    Subscription addSubscription(Long userId, String serviceName);
    List<Subscription> getSubscriptionByUserId(Long userId);
    void deleteSubscription(Long userId, Long subscriptionId);
    public List<String> getTop3Subscriptions();
}
