package com.mealci.dal.food;

import com.mealci.dal.users.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "food")
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int category;
    private double quantity;
    private int measure;
    private String brand;
    private int state;
    private Instant createAt;
    private String barcode;
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private int nutriScore;
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private int novaGroupScore;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public UserEntity user;

    public FoodEntity(String name,
                      int category,
                      double quantity,
                      int measure,
                      String brand,
                      int state,
                      String barcode,
                      int nutriScore,
                      int novaGroupScore) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.measure = measure;
        this.brand = brand;
        this.state = state;
        this.createAt = Instant.now();
        this.barcode = barcode;
        this.nutriScore = nutriScore;
        this.novaGroupScore = novaGroupScore;
    }

    public FoodEntity() {}
}
