package br.com.FightSystem.mapper;

import br.com.FightSystem.domain.EnrollModel;
import br.com.FightSystem.domain.PlanModel;
import br.com.FightSystem.dto.EnrollDTO;
import br.com.FightSystem.domain.MemberModel;
import org.springframework.stereotype.Component;

public class EnrollMapper {

    public static EnrollModel map(EnrollDTO enrollDTO) {
        PlanModel planModel = PlanModel.builder()
                .id(enrollDTO.plan().id())
                .build();

        MemberModel memberModel = MemberModel.builder()
                .id(enrollDTO.member().id())
                .build();

        return EnrollModel.builder()
                .id(enrollDTO.id())
                .planModel(planModel)
                .memberModel(memberModel)
                .enrollStatus(enrollDTO.enrollStatus())
                .build();
    }

    public static EnrollDTO map(EnrollModel enrollModel) {
        return EnrollDTO.builder()
                .id(enrollModel.getId())
                .plan(PlanMapper.map(enrollModel.getPlanModel()))
                .member(MemberMapper.map(enrollModel.getMemberModel()))
                .enrollStatus(enrollModel.getEnrollStatus())
                .build();
    }
}
