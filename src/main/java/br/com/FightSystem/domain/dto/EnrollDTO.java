package br.com.FightSystem.domain.dto;

public record EnrollDTO(
        Long id,
        PlanDTO plan,
        MemberDTO member,
        boolean enrolled) {
}
