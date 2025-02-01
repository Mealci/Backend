package com.mealci.core.poop_monitoring;

import com.mealci.core.additional_asspects.AdditionalAsspect;
import com.mealci.core.jwt.JwtService;
import com.mealci.core.poop_monitoring.create.CreatePoopMonitoringRequest;
import com.mealci.core.results.Result;
import com.mealci.dal.poop_monitoring.repositories.CustomPoopMonitoringRepository;
import com.mealci.dal.users.UserRepository;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;


@Service
public class PoopMonitoringServiceImpl implements PoopMonitoringService{
    private final CustomPoopMonitoringRepository customPoopMonitoringRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public PoopMonitoringServiceImpl(CustomPoopMonitoringRepository customPoopMonitoringRepository,
                                     JwtService jwtService,
                                     UserRepository userRepository) {
        this.customPoopMonitoringRepository = customPoopMonitoringRepository;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    public Result<PoopMonitoring> create(CreatePoopMonitoringRequest request) {
        var email = jwtService.extractEmail();
        var poopingNumber = customPoopMonitoringRepository.countTodayPoopingNumber(email, Instant.now());
        if (!poopingNumber.isSuccess()) {
            return Result.failure(poopingNumber.getErrorCode());
        }

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
                additionalAspect,
                poopingNumber.getValue());

        var user = userRepository.findByEmailEntity(email);
        if (user.isEmpty()) {
            return Result.failure("Can't find user with this email");
        }

        var result = customPoopMonitoringRepository.create(poopMonitoring, user.get().email.address);
        if (!result.isSuccess()) {
            return Result.failure(result.getErrorCode());
        }

        return Result.success(poopMonitoring);
    }

    @Override
    public PoopMonitoring delete(int id) {
        return null;
    }

    @Override
    public List<PoopMonitoring> getByUserId(int id) {
        return List.of();
    }
}
