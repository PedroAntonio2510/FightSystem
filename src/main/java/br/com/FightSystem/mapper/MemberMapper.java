package br.com.FightSystem.mapper;

import br.com.FightSystem.domain.MemberModel;
import br.com.FightSystem.dto.MemberDTO;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public static MemberDTO map(MemberModel memberModel) {
        return MemberDTO.builder()
                .id(memberModel.getId())
                .name(memberModel.getName())
                .cpf(memberModel.getCpf())
                .email(memberModel.getEmail())
                .birthDate(memberModel.getBirthDate())
                .belt(memberModel.getBelt())
                .build();
    }

    public static MemberModel map(MemberDTO memberDTO) {
        return MemberModel.builder()
                .name(memberDTO.name())
                .cpf(memberDTO.cpf())
                .email(memberDTO.email())
                .birthDate(memberDTO.birthDate())
                .belt(memberDTO.belt())
                .build();
    }
}
