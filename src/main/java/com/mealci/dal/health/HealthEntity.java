package com.mealci.dal.health;

import com.mealci.dal.sleep.SleepEntity;
import com.mealci.dal.sport.SportEntity;
import com.mealci.dal.users.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "health")
public class HealthEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Instant created_at;
    private int psychologicalState;
    private int physicalDolor;

    @OneToMany(mappedBy = "health", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SportEntity> sportEntities = new ArrayList<>();

    @OneToMany(mappedBy = "health", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SleepEntity> sleepEntities = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public HealthEntity(Instant created_at,
                        int psychologicalState,
                        int physicalDolor) {
        this.created_at = created_at;
        this.psychologicalState = psychologicalState;
        this.physicalDolor = physicalDolor;
    }

    public HealthEntity() {}
}
