package br.com.FightSystem.mapper;

import br.com.FightSystem.domain.Member;
import br.com.FightSystem.dto.MemberDTO;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public static MemberDTO map(Member member) {
        return MemberDTO.builder()
                .id(member.getId())
                .name(member.getName())
                .cpf(member.getCpf())
                .email(member.getEmail())
                .birthDate(member.getBirthDate())
                .belt(member.getBelt())
                .build();
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
