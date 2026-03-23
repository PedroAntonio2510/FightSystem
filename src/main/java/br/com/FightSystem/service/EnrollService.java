package br.com.FightSystem.service;

import br.com.FightSystem.domain.Enroll;
import br.com.FightSystem.domain.Plan;
import br.com.FightSystem.domain.dto.EnrollDTO;
import br.com.FightSystem.domain.dto.MemberDTO;
import br.com.FightSystem.domain.dto.PlanDTO;
import br.com.FightSystem.domain.member.Member;
import br.com.FightSystem.mapper.EnrollMapper;
import br.com.FightSystem.mapper.MemberMapper;
import br.com.FightSystem.mapper.PlanMapper;
import br.com.FightSystem.repository.EnrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollService {

    private final EnrollRepository enrollRepository;
    private final MemberService memberService;
    private final PlanService planService;

    public EnrollService(EnrollRepository enrollRepository, MemberService memberService, PlanService planService) {
        this.enrollRepository = enrollRepository;
        this.memberService = memberService;
        this.planService = planService;
    }

    public List<EnrollDTO> findAll() {
        List<Enroll> enrolls = enrollRepository.findAll();
        return enrolls.stream().map(EnrollMapper::map).toList();
    }

    public EnrollDTO findById(Long id) {
        Enroll enroll = enrollRepository.findById(id).orElse(null);
        return EnrollMapper.map(enroll);
    }

    public EnrollDTO save(EnrollDTO enrollDTO) {
        Enroll enroll = EnrollMapper.map(enrollDTO);

        Plan planFound = findPlan(enroll.getPlan().getId());
        Member memberFound = findMember(enroll.getMember().getId());

        enroll.setPlan(planFound);
        enroll.setMember(memberFound);
        enrollRepository.save(enroll);
        return EnrollMapper.map(enroll);
    }

    public Optional<EnrollDTO> update(Long id, Enroll updatedEnroll) {
        Optional<Enroll> optEnroll = enrollRepository.findById(id);
        if (optEnroll.isPresent()) {
            Plan plan = findPlan(updatedEnroll.getPlan().getId());
            Member member = findMember(updatedEnroll.getMember().getId());
            Enroll enroll = optEnroll.get();

            enroll.setPlan(plan);
            enroll.setMember(member);
            enroll.setEnrolled(enroll.isEnrolled());

            return Optional.of(EnrollMapper.map(enroll));
        }
        return Optional.empty();
    }

    public void deleteById(Long id) {
        enrollRepository.deleteById(id);
    }

    public Plan findPlan(Long id) {
        PlanDTO plan = planService.findById(id);
        return PlanMapper.map(plan);
    }

    public Member findMember(Long id) {
        MemberDTO memberDTO = memberService.findById(id);
        return MemberMapper.map(memberDTO);
    }
}
