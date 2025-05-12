package org.example.tech_spec_java_spring_final_v2.controller;

import lombok.RequiredArgsConstructor;
import org.example.tech_spec_java_spring_final_v2.entity.Subscription;
import org.example.tech_spec_java_spring_final_v2.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Subscription> addSubscription (@PathVariable Long userId,
                                                         @RequestBody String serviceName){
        Subscription subscription = subscriptionService.addSubscription(userId,serviceName);
        return ResponseEntity.status(201).body(subscription);
    }

    @GetMapping
    public ResponseEntity<List<Subscription>> getSubscriptions (@PathVariable Long userId) {
        List<Subscription> subscriptions = subscriptionService.getSubscriptionByUserId(userId);
        return ResponseEntity.ok(subscriptions);
    }

    @DeleteMapping("{subId}")
    public ResponseEntity<Void> deleteSubscription (@PathVariable Long userId,
                                                    @PathVariable Long subId) {
        subscriptionService.deleteSubscription(userId,subId);
        return ResponseEntity.noContent().build();
    }
}
