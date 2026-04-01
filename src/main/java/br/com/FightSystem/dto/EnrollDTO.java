package br.com.FightSystem.dto;

import jakarta.validation.constraints.NotNull;

public record EnrollDTO(
        Long id,
        @NotNull(message = "Plan is necessary")
        PlanDTO plan,

        @NotNull(message = "Member is necessary")
        MemberDTO member,

        boolean enrolled) {
}
