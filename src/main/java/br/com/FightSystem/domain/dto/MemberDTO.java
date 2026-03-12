package br.com.FightSystem.domain.dto;

import java.time.LocalDate;

public record MemberDTO(
        Long id,
        String name,
        String cpf,
        String email,
        LocalDate birthDate,
        String belt
        ) {
}
