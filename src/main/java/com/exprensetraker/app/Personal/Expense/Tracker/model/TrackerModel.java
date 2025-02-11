package com.exprensetraker.app.Personal.Expense.Tracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "finance_entries")
public class TrackerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    private String category; // e.g., Food, Entertainment, Salary

    private LocalDate date;

    private String description;

    private String type; // "income" or "expense"

    // Default Constructor
    public TrackerModel() {
    }

    // Parameterized Constructor
    public TrackerModel(Long id, double amount, String category, LocalDate date, String description, String type) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
        this.type = type;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
