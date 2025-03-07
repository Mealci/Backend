package com.mealci.dal.sleep;

import com.mealci.dal.health.HealthEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Period;

@Entity
@Getter
@Setter
@Table(name = "sleep")
public class SleepEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Period period;
    private int quality;

    @ManyToOne
    @JoinColumn(name = "health_id", nullable = false)
    private HealthEntity health;

    public SleepEntity(Period period, int quality) {
        this.period = period;
        this.quality = quality;
    }

    public SleepEntity() {}
}
