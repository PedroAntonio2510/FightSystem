package br.com.FightSystem.service;

import br.com.FightSystem.domain.Plan;
import br.com.FightSystem.domain.dto.PlanDTO;
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

    public PlanDTO findById(Long id) {
        Plan planFound = planRepository.findById(id).orElse(null);
        return PlanMapper.map(planFound);
    }

    public List<PlanDTO> findAll() {
        return planRepository.findAll().stream().map(PlanMapper::map).toList();
    }

    public PlanDTO save(PlanDTO planDTO) {
        Plan savedPlan = planRepository.save(PlanMapper.map(planDTO));
        return PlanMapper.map(savedPlan);
    }

    public PlanDTO update(PlanDTO plan, Long id) {
        planRepository.findById(id).orElseThrow(null);
        Plan updatedPlan = PlanMapper.map(plan);
        updatedPlan.setId(id);
        Plan savedPlan = planRepository.save(updatedPlan);
        return PlanMapper.map(updatedPlan);
    }

    public void delete(Long id) {
        planRepository.findById(id)
                .orElseThrow(null);
        planRepository.deleteById(id);
    }
}

