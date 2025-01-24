package com.mealci.core.users;

import com.mealci.core.results.Result;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Result<Integer> getUserId();
}
