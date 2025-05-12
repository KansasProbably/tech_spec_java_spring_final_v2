package org.example.tech_spec_java_spring_final_v2.controller;


import lombok.RequiredArgsConstructor;

import org.example.tech_spec_java_spring_final_v2.entity.Subscription;
import org.example.tech_spec_java_spring_final_v2.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subscriptions")
public class TopSubscriptionsController {

    private  final SubscriptionService subscriptionService;

    @GetMapping("/top")
    public ResponseEntity<List<String>> getTopSubscriptions() {
        List<String> topSubscriptions = subscriptionService.getTop3Subscriptions();
        return ResponseEntity.ok(topSubscriptions);
    }
}
