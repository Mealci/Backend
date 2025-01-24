package com.mealci.dal.poop;

import com.mealci.core.stool_composition.StoolComposition;
import com.mealci.dal.users.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "poop_monitoring")
public class PoopMonitoringEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public Date createdAt;
    public int stoolComposition;
    public int poopingNumber;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
