package br.com.FightSystem.mapper;

import br.com.FightSystem.domain.PlanModel;
import br.com.FightSystem.dto.PlanDTO;
import org.springframework.stereotype.Component;

public class PlanMapper {

    public static PlanModel map(PlanDTO planDTO) {
        return PlanModel.builder()
                .id(planDTO.id())
                .name(planDTO.name())
                .price(planDTO.price())
                .description(planDTO.description())
                .monthDuration(planDTO.monthDuration())
                .build();
    }

    public static PlanDTO map(PlanModel planModel) {
        return PlanDTO.builder()
                .id(planModel.getId())
                .name(planModel.getName())
                .price(planModel.getPrice())
                .description(planModel.getDescription())
                .monthDuration(planModel.getMonthDuration())
                .build();
    }
}
