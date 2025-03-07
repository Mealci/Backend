package com.mealci.dal.sport;

import com.mealci.dal.health.HealthEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Period;

@Entity
@Getter
@Setter
@Table(name = "sport")
public class SportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Period period;
    private int intensity;

    @ManyToOne
    @JoinColumn(name = "health_id", nullable = false)
    private HealthEntity health;

    public SportEntity(Period period, int intensity) {
        this.period = period;
        this.intensity = intensity;
    }

    public SportEntity() {}
}
