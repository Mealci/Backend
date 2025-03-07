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
    public boolean hasExcessiveFlatulence;
    public boolean hasPain;
    public boolean hasAbdominalBloating;
    public boolean hasMucus;
    public boolean hasFoodResidue;
    public boolean hasColic;
    public boolean hasUnusualSmells;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public UserEntity user;

    public PoopMonitoringEntity(Instant createdAt,
                                int stoolComposition,
                                int quantity,
                                int feeling,
                                boolean hasExcessiveFlatulence,
                                boolean hasPain,
                                boolean hasAbdominalBloating,
                                boolean hasMucus,
                                boolean hasFoodResidue,
                                boolean hasColic,
                                boolean hasUnusualSmells) {
        this.createdAt = createdAt;
        this.stoolComposition = stoolComposition;
        this.quantity = quantity;
        this.feeling = feeling;
        this.hasExcessiveFlatulence = hasExcessiveFlatulence;
        this.hasPain = hasPain;
        this.hasAbdominalBloating = hasAbdominalBloating;
        this.hasMucus = hasMucus;
        this.hasFoodResidue = hasFoodResidue;
        this.hasColic = hasColic;
        this.hasUnusualSmells = hasUnusualSmells;
    }

    public PoopMonitoringEntity() {}
}
