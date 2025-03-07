package com.mealci.dal.health.repositories;

import com.mealci.dal.health.HealthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRepository extends JpaRepository<HealthEntity, Integer> {}
