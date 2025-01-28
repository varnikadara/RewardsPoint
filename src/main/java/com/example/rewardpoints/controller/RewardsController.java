package com.example.rewardpoints.controller;

import com.example.rewardpoints.model.CustomerRewards;
import com.example.rewardpoints.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

    private final TransactionService transactionService;

    public RewardsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/calculate")
    public Map<String, CustomerRewards> getRewardsSummary() {
        return transactionService.calculateRewards();
    }
}
