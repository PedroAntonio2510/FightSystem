package br.com.FightSystem.controller;

import br.com.FightSystem.domain.Plan;
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
        Plan plan = planService.findById(id);
        return ResponseEntity.ok(PlanMapper.map(plan));
    }

    @PostMapping
    public ResponseEntity<PlanDTO> save(@RequestBody PlanDTO planDTO) {
        Plan savedPlan = planService.save(planDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(PlanMapper.map(savedPlan));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, PlanDTO>> update(@PathVariable Long id,
                                          @RequestBody PlanDTO planDTO) {
        Plan updatedPlan = planService.update(planDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("updatedPlan", PlanMapper.map(updatedPlan)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        planService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
