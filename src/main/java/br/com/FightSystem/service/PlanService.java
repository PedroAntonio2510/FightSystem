package br.com.FightSystem.service;

import br.com.FightSystem.domain.Plan;
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

    public Plan findById(Long id) {
        Plan planFound = planRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Plan not found"));
        return planFound;
    }

    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    public Plan save(PlanDTO planDTO) {
        Plan savedPlan = planRepository.save(PlanMapper.map(planDTO));
        return savedPlan;
    }

    public Plan update(PlanDTO plan, Long id) {
        planRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Plan not found"));
        Plan updatedPlan = PlanMapper.map(plan);
        updatedPlan.setId(id);
        Plan savedPlan = planRepository.save(updatedPlan);
        return savedPlan;
    }

    public void deleteById(Long id) {
        planRepository.findById(id)
                .orElseThrow(null);
        planRepository.deleteById(id);
    }
}

