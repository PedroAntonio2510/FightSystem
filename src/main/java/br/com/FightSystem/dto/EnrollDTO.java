package br.com.FightSystem.dto;

import br.com.FightSystem.domain.enums.EnrollStatus;
import jakarta.validation.constraints.NotNull;

public record EnrollDTO(
        Long id,
        @NotNull(message = "Plan is necessary")
        PlanDTO plan,

        @NotNull(message = "Member is necessary")
        MemberDTO member,

        EnrollStatus enrollStatus) {
}
