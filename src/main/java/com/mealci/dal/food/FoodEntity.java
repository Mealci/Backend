package com.mealci.dal.food;

import com.mealci.dal.users.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public UserEntity user;
}
