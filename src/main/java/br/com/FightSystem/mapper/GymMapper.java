package br.com.FightSystem.mapper;

import br.com.FightSystem.domain.GymModel;
import br.com.FightSystem.dto.GymDTO;
import org.springframework.stereotype.Component;


public class GymMapper {

    public static GymDTO toDTO(GymModel gymModel) {
        return GymDTO.builder()
                .id(gymModel.getId())
                .name(gymModel.getName())
                .address(gymModel.getAddress())
                .build();
    }

    public static GymModel toModel(GymDTO gymDTO) {
        return GymModel.builder()
                .id(gymDTO.id())
                .name(gymDTO.name())
                .address(gymDTO.address())
                .build();
    }
}
