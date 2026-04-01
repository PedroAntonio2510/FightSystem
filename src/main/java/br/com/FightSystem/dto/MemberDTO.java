package br.com.FightSystem.dto;

import br.com.FightSystem.domain.Enroll;

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
