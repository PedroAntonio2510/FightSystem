package br.com.FightSystem.mapper;

import br.com.FightSystem.domain.Member;
import br.com.FightSystem.dto.MemberDTO;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public static MemberDTO map(Member member) {
        return new MemberDTO(member.getId(),
                member.getName(),
                member.getCpf(),
                member.getEmail(),
                member.getBirthDate(),
                member.getBelt());
    }

    public static Member map(MemberDTO memberDTO) {
        return Member.builder()
                .name(memberDTO.name())
                .cpf(memberDTO.cpf())
                .email(memberDTO.email())
                .birthDate(memberDTO.birthDate())
                .belt(memberDTO.belt())
                .build();
    }
}
