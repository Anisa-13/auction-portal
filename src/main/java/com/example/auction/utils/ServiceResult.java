package com.example.auction.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResult {
    protected boolean success;
    protected String message;

    public static ServiceResult Error(String message) {
        return ServiceResult.builder()
                .success(false)
                .message(message)
                .build();
    }

    public static ServiceResult Success() {
        return ServiceResult.builder()
                .success(true)
                .build();
    }
}
