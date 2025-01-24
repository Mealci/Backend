package com.mealci.core.results;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Result<T> {
    @Getter
    private boolean success;
    private T data;
    private String errorCode;

    public Result(boolean success, T data, String errorCode) {
        this.success = success;
        this.data = data;
        this.errorCode = errorCode;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(true, data, null);
    }

    public static <T> Result<T> failure(String errorCode) {
        return new Result<>(false, null, errorCode);
    }
}