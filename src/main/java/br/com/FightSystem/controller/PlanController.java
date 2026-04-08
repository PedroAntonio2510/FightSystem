package br.com.FightSystem.controller;

import br.com.FightSystem.domain.PlanModel;
import br.com.FightSystem.dto.PlanDTO;
import br.com.FightSystem.mapper.PlanMapper;
import br.com.FightSystem.service.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public ResponseEntity<Map<String, List<PlanDTO>>> listAll() {
        List<PlanDTO> plans = planService.findAll().stream().map(PlanMapper::map).toList();
        return ResponseEntity.ok(Map.of("plans",
                plans));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanDTO> findById(@PathVariable Long id) {
        PlanModel planModel = planService.findById(id);
        return ResponseEntity.ok(PlanMapper.map(planModel));
    }

    @PostMapping
    public ResponseEntity<PlanDTO> save(@RequestBody PlanDTO planDTO) {
        PlanModel savedPlanModel = planService.save(planDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(PlanMapper.map(savedPlanModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, PlanDTO>> update(@PathVariable Long id,
                                          @RequestBody PlanDTO planDTO) {
        PlanModel updatedPlanModel = planService.update(planDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("updatedPlan", PlanMapper.map(updatedPlanModel)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        planService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
