package com.example.auction.service.auction.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BidRequest {
    @NotEmpty
    protected String id;
    protected double amount;
}
