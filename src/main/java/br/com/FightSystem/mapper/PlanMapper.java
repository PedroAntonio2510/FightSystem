package br.com.FightSystem.mapper;

import br.com.FightSystem.domain.Plan;
import br.com.FightSystem.dto.PlanDTO;
import org.springframework.stereotype.Component;

@Component
public class PlanMapper {

    public static Plan map(PlanDTO planDTO) {
        return Plan.builder()
                .id(planDTO.id())
                .name(planDTO.name())
                .price(planDTO.price())
                .description(planDTO.description())
                .monthDuration(planDTO.monthDuration())
                .build();
    }

    public static PlanDTO map(Plan plan) {
        return new PlanDTO(
                plan.getId(),
                plan.getName(),
                plan.getPrice(),
                plan.getDescription(),
                plan.getMonthDuration()
        );
    }
}
