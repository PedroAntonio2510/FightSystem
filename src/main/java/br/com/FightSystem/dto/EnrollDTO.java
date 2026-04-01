package br.com.FightSystem.dto;

public record EnrollDTO(
        Long id,
        PlanDTO plan,
        MemberDTO member,
        boolean enrolled) {
}
