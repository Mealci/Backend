package com.mealci.core.poop_monitoring;

import com.mealci.core.additional_asspects.AdditionalAsspect;
import com.mealci.core.poop_monitoring.create.CreatePoopMonitoringRequest;
import com.mealci.core.users.UserService;
import com.mealci.dal.poop_monitoring.repositories.CustomPoopMonitoringRepository;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class PoopMonitoringServiceImpl implements PoopMonitoringService{
    private final CustomPoopMonitoringRepository customPoopMonitoringRepository;
    private final UserService userService;

    public PoopMonitoringServiceImpl(CustomPoopMonitoringRepository customPoopMonitoringRepository,
                                     UserService userService) {
        this.customPoopMonitoringRepository = customPoopMonitoringRepository;
        this.userService = userService;
    }

    @Override
    public PoopMonitoring create(CreatePoopMonitoringRequest request) {
        var additionalAspect = AdditionalAsspect.create(
                request.HasExcessiveFlatulence(),
                request.HasPain(),
                request.HasAbdominalBloating(),
                request.HasMucus(),
                request.HasFoodResidue(),
                request.HasColic(),
                request.HasUnusualSmells()
        );

        var poopMonitoring = PoopMonitoring.create(Instant.now(),
                request.stoolComposition(),
                request.quantity(),
                request.feeling(),
                additionalAspect);

        var user = userService.getCurrentUser();
        var email = user.email.address;

        return customPoopMonitoringRepository.create(poopMonitoring, email);
    }
}
