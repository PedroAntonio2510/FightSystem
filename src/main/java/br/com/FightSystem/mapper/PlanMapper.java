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
        return PlanDTO.builder()
                .id(plan.getId())
                .name(plan.getName())
                .price(plan.getPrice())
                .description(plan.getDescription())
                .monthDuration(plan.getMonthDuration())
                .build();
    }
}
