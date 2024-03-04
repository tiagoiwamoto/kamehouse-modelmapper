package br.com.kamehouse.kamehousemodelmapper;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class AppDto {
    private UUID uuid;
    private LocalDate data;
    private String valor;
    private ValidateEnum validated;
    private String name;
    private String phone;
}
