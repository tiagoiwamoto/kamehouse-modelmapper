package br.com.kamehouse.kamehousemodelmapper;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AppController {
    private final AppMapper mapper;

    @GetMapping
    public ResponseEntity pojoTest(){
        AppDto dto = new AppDto();
        Faker faker = new Faker(Locale.of("pt-BR"));
        dto.setData(LocalDate.now());
        dto.setName(faker.name().fullName());
        dto.setPhone(faker.phoneNumber().cellPhone());
        dto.setValor(new Random().nextInt(9999) + "," + new Random().nextInt(99));
        dto.setUuid(UUID.randomUUID());
        dto.setValidated(ValidateEnum.VALIDATED);

        var converted = mapper.toPojo(dto);
        return ResponseEntity.ok(converted);
    }

}
