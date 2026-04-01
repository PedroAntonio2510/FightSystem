package br.com.FightSystem.dto;

import br.com.FightSystem.domain.Enroll;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record MemberDTO(
        Long id,

        @NotNull(message = "Name is necessary")
        String name,

        @NotNull(message = "CPF is necessary")
        @CPF(message = "cpf is not valid")
        String cpf,

        @NotNull(message = "Email is necessary")
        @Email(message = "email is not valid")
        String email,

        @NotNull(message = "Birth Date is necessary")
        LocalDate birthDate,

        @NotNull(message = "Belt is necessary")
        String belt

        ) {
}
