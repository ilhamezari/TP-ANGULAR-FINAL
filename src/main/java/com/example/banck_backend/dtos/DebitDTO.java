package com.example.banck_backend.dtos;

import lombok.Data;

@Data
public class DebitDTO {

    private String accountId;
    private double amount;
    private String description;
}
