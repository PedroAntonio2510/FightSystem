package br.com.FightSystem.service;

import br.com.FightSystem.domain.EnrollModel;
import br.com.FightSystem.domain.MemberModel;
import br.com.FightSystem.domain.PlanModel;
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
        List<EnrollModel> enrollModels = enrollRepository.findAll();
        return enrollModels.stream().map(EnrollMapper::map).toList();
    }

    public EnrollDTO findById(Long id) {
        EnrollModel enrollModel = enrollRepository.findById(id).orElse(null);
        return EnrollMapper.map(enrollModel);
    }

    public EnrollDTO save(EnrollDTO enrollDTO) {
        EnrollModel enrollModel = EnrollMapper.map(enrollDTO);

        if (enrollModel.getEnrollStatus() == null) {
            enrollModel.setEnrollStatus(br.com.FightSystem.domain.enums.EnrollStatus.INACTIVE);
        }

        PlanModel planModel = planService.findById(enrollModel.getPlanModel().getId());
        MemberModel memberModel = memberService.findById(enrollModel.getMemberModel().getId());

        enrollModel.setPlanModel(planModel);
        enrollModel.setMemberModel(memberModel);
        enrollRepository.save(enrollModel);
        return EnrollMapper.map(enrollModel);
    }

    public Optional<EnrollDTO> update(Long id, EnrollModel updatedEnrollModel) {
        Optional<EnrollModel> optEnroll = enrollRepository.findById(id);
        if (optEnroll.isPresent()) {
            PlanModel planModel = planService.findById(updatedEnrollModel.getPlanModel().getId());
            MemberModel memberModel = memberService.findById(updatedEnrollModel.getMemberModel().getId());
            EnrollModel enrollModel = optEnroll.get();

            enrollModel.setPlanModel(planModel);
            enrollModel.setMemberModel(memberModel);
            enrollModel.setEnrollStatus(updatedEnrollModel.getEnrollStatus());

            enrollRepository.save(enrollModel);

            return Optional.of(EnrollMapper.map(enrollModel));
        }
        return Optional.empty();
    }

    public void deleteById(Long id) {
        enrollRepository.deleteById(id);
    }
}
