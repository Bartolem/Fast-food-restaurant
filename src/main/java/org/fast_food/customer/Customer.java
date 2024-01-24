package org.fast_food.customer;

import java.time.LocalDateTime;
import java.util.UUID;

public class Customer {
    private final String id;
    private String name;
    private String email;
    private String phoneNumber;
    private int points;
    private final LocalDateTime creationDate;

    public Customer(String name, String email, String phoneNumber) {
        this.id = generateUniqueId();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.points = 0;
        this.creationDate = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.isEmpty()) {
            this.email = email;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.isEmpty()) {
            this.phoneNumber = phoneNumber;
        }
    }

    public int getPoints() {
        return points;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void addPoints(int amount) {
        if (amount > 0) {
            this.points += amount;
        }
    }

    public void removePoints(int amount) {
        if (amount > 0 && this.points - amount > 0) {
            this.points -= amount;
        }
    }

    private String generateUniqueId() {
        return String.valueOf(UUID.randomUUID());
    }
}
