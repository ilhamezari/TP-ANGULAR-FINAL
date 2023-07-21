package com.example.banck_backend.dtos;
import lombok.Data;

@Data
public class TrnasferReqDTO {
    private String accountSource;
    private String accountDestination;
    private double amount;
    private String description;
}
