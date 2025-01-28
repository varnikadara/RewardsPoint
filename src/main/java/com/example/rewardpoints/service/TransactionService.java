package com.example.rewardpoints.service;

import com.example.rewardpoints.model.CustomerRewards;
import com.example.rewardpoints.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    // Mock data
    private final List<Transaction> transactions = Arrays.asList(
            new Transaction("Alice", 120.0, "2023-01-15"),
            new Transaction("Alice", 75.0, "2023-01-25"),
            new Transaction("Bob", 200.0, "2023-02-10"),
            new Transaction("Bob", 50.0, "2023-02-20"),
            new Transaction("Alice", 130.0, "2023-03-05"),
            new Transaction("Bob", 85.0, "2023-03-15")
    );

    public Map<String, CustomerRewards> calculateRewards() {
        Map<String, List<Transaction>> customerTransactions = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCustomerName));

        Map<String, CustomerRewards> rewardsData = new HashMap<>();

        customerTransactions.forEach((customerName, transactions) -> {
            CustomerRewards customerRewards = new CustomerRewards();

            transactions.forEach(transaction -> {
                int rewardPoints = computePoints(transaction.getAmount());
                String month = transaction.getDate().substring(0, 7); // Extract year and month
                customerRewards.addMonthlyPoints(month, rewardPoints);
            });

            rewardsData.put(customerName, customerRewards);
        });

        return rewardsData;
    }

    public int computePoints(double amount) {
        if (amount > 100) {
            return (int) ((amount - 100) * 2 + 50);
        } else if (amount > 50) {
            return (int) (amount - 50);
        } else {
            return 0;
        }
    }
}
