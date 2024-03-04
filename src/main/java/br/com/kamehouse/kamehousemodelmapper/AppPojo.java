package br.com.kamehouse.kamehousemodelmapper;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class AppPojo {
    private Long id;
    private UUID uuid;
    private LocalDate data;
    private BigDecimal valor;
    private Boolean validated;
    private String name;
    private Long phone;
}
