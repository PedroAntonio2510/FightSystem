package br.com.FightSystem.service;

import br.com.FightSystem.domain.PlanModel;
import br.com.FightSystem.dto.PlanDTO;
import br.com.FightSystem.mapper.PlanMapper;
import br.com.FightSystem.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public PlanModel findById(Long id) {
        PlanModel planModelFound = planRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Plan not found"));
        return planModelFound;
    }

    public List<PlanModel> findAll() {
        return planRepository.findAll();
    }

    public PlanModel save(PlanDTO planDTO) {
        PlanModel savedPlanModel = planRepository.save(PlanMapper.map(planDTO));
        return savedPlanModel;
    }

    public PlanModel update(PlanDTO plan, Long id) {
        planRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Plan not found"));
        PlanModel updatedPlanModel = PlanMapper.map(plan);
        updatedPlanModel.setId(id);
        PlanModel savedPlanModel = planRepository.save(updatedPlanModel);
        return savedPlanModel;
    }

    public void deleteById(Long id) {
        planRepository.findById(id)
                .orElseThrow(null);
        planRepository.deleteById(id);
    }
}

