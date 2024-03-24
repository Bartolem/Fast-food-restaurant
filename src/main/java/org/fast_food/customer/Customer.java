package org.fast_food.customer;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

public class Customer {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private char[] password;
    private String phoneNumber;
    private int points;
    private Date creationDate;

    public Customer(String firstName, String lastName, String email, char[] password, String phoneNumber) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.points = 0;
        this.creationDate = Date.valueOf(String.valueOf(LocalDate.now()));
    }

    public Customer(UUID id, String firstName, String lastName, String email, char[] password, String phoneNumber, int points, Date creationDate) {
        this(firstName, lastName, email, password, phoneNumber);
        this.id = id;
        this.points = points;
        this.creationDate = creationDate;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!firstName.isEmpty()) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!lastName.isEmpty()) {
            this.lastName = lastName;
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

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
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

    public Date getCreationDate() {
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

    @Override
    public String toString() {
        return "{id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", points=" + points +
                ", creationDate=" + creationDate + "\n}";
    }
}
