package com.mealci.dal.poop_monitoring;

import com.mealci.dal.users.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "poop_monitoring")
public class PoopMonitoringEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public Instant createdAt;
    public int stoolComposition;
    public int quantity;
    public int feeling;
    public boolean HasExcessiveFlatulence;
    public boolean HasPain;
    public boolean HasAbdominalBloating;
    public boolean HasMucus;
    public boolean HasFoodResidue;
    public boolean HasColic;
    public boolean HasUnusualSmells;
    public int poopingNumber;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
