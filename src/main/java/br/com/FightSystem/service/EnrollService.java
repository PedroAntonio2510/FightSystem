package br.com.FightSystem.service;

import br.com.FightSystem.domain.Enroll;
import br.com.FightSystem.domain.Member;
import br.com.FightSystem.domain.Plan;
import br.com.FightSystem.dto.EnrollDTO;
import br.com.FightSystem.mapper.EnrollMapper;
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

        Plan plan = planService.findById(enroll.getPlan().getId());
        Member member = memberService.findById(enroll.getMember().getId());


        enroll.setPlan(plan);
        enroll.setMember(member);
        enrollRepository.save(enroll);
        return EnrollMapper.map(enroll);
    }

    public Optional<EnrollDTO> update(Long id, Enroll updatedEnroll) {
        Optional<Enroll> optEnroll = enrollRepository.findById(id);
        if (optEnroll.isPresent()) {
            Plan plan = planService.findById(updatedEnroll.getPlan().getId());
            Member member = memberService.findById(updatedEnroll.getMember().getId());
            Enroll enroll = optEnroll.get();

            enroll.setPlan(plan);
            enroll.setMember(member);
            enroll.setEnrolled(updatedEnroll.isEnrolled());

            enrollRepository.save(enroll);

            return Optional.of(EnrollMapper.map(enroll));
        }
        return Optional.empty();
    }

    public void deleteById(Long id) {
        enrollRepository.deleteById(id);
    }
}
