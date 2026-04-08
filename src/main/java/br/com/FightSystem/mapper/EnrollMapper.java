package br.com.FightSystem.mapper;

import br.com.FightSystem.domain.Enroll;
import br.com.FightSystem.domain.Plan;
import br.com.FightSystem.dto.EnrollDTO;
import br.com.FightSystem.domain.Member;
import org.springframework.stereotype.Component;

@Component
public class EnrollMapper {

    public static Enroll map(EnrollDTO enrollDTO) {
        Plan plan = Plan.builder()
                .id(enrollDTO.plan().id())
                .build();

        Member member = Member.builder()
                .id(enrollDTO.member().id())
                .build();

        return Enroll.builder()
                .id(enrollDTO.id())
                .plan(plan)
                .member(member)
                .enrollStatus(enrollDTO.enrollStatus())
                .build();
    }

    public static EnrollDTO map(Enroll enroll) {
        return EnrollDTO.builder()
                .id(enroll.getId())
                .plan(PlanMapper.map(enroll.getPlan()))
                .member(MemberMapper.map(enroll.getMember()))
                .enrollStatus(enroll.getEnrollStatus())
                .build();
    }
}
