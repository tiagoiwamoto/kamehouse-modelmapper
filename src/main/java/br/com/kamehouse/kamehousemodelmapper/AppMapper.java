package br.com.kamehouse.kamehousemodelmapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppMapper {

    private final ModelMapper mapper;

    public AppDto toDto(AppPojo pojo){
        var converted = mapper.map(pojo, AppDto.class);
        return converted;
    }

    public AppPojo toPojo(AppDto dto){
        var converted = mapper.map(dto, AppPojo.class);
        return converted;
    }

}
