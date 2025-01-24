package com.mealci.core.poop_monitoring;

import com.mealci.core.jwt.JwtService;
import com.mealci.core.poop_monitoring.create.CreatePoopMonitoringRequest;
import com.mealci.core.results.Result;
import com.mealci.core.stool_composition.StoolComposition;
import com.mealci.core.users.UserService;
import com.mealci.dal.poop.PoopMonitoringRepository;
import com.mealci.dal.users.UserRepository;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.Date;
import java.util.List;


@Service
public class PoopMonitoringServiceImpl implements PoopMonitoringService{
    private final UserService userService;
    private final PoopMonitoringRepository poopMonitoringRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public PoopMonitoringServiceImpl(UserService userService,
                                     PoopMonitoringRepository poopMonitoringRepository,
                                     JwtService jwtService, UserRepository userRepository){
        this.userService = userService;
        this.poopMonitoringRepository = poopMonitoringRepository;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    public Result<PoopMonitoring> create(CreatePoopMonitoringRequest request) {
        var id = userService.getUserId();
        if (!id.isSuccess()) {
            return Result.failure(id.getErrorCode());
        }

        var today = getCurrentDate();
        var poopingNumber = poopMonitoringRepository.countPoopingNumber(id.getData(), today);
        var poopMonitoring = PoopMonitoring.create(today, , poopingNumber, id.getData());
        var email = jwtService.extractEmail();
        var user = userRepository.findByEmailEntity(email);
        if (user.isEmpty()) {
            return Result.failure("Invalid email");
        }

        var result = poopMonitoringRepository.create(poopMonitoring, user.get());
        poopMonitoringRepository.save(result, user.get());

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

    private Date getCurrentDate() {
        var localDate = LocalDate.now();
        var localDateTime = localDate.atStartOfDay();

        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
