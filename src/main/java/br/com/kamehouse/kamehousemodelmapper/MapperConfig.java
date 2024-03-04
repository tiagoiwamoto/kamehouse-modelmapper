package br.com.kamehouse.kamehousemodelmapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper app(){
        var mapper = new ModelMapper();
        mapper.createTypeMap(AppDto.class, AppPojo.class)
                .addMappings(field -> field
                        .using(toValueMoney())
                        .map(AppDto::getValor, AppPojo::setValor))
                .addMappings(field -> field
                        .using(toValidate())
                        .map(AppDto::getValidated, AppPojo::setValidated))
                .addMappings(field -> field
                        .using(toPhone())
                        .map(AppDto::getPhone, AppPojo::setPhone));

        return mapper;
    }

    private Converter<String, BigDecimal> toValueMoney(){
        return context -> BigDecimal.valueOf(Double.parseDouble(context.getSource().replaceAll(",",".")));
    }

    private Converter<ValidateEnum, Boolean> toValidate(){
        return context -> context.getSource() == ValidateEnum.VALIDATED ? true : false;
    }

    private Converter<String, Long> toPhone(){
        return context -> Long.valueOf(context.getSource().replaceAll("[^\\d.]", ""));
    }

}
