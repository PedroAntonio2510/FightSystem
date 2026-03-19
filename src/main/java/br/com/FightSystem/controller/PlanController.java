package br.com.FightSystem.controller;

import br.com.FightSystem.domain.dto.PlanDTO;
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
        return ResponseEntity.ok(Map.of("plans",
                planService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(planService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PlanDTO> save(@RequestBody PlanDTO planDTO) {
        PlanDTO savedPlan = planService.save(planDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, PlanDTO>> update(@PathVariable Long id,
                                          @RequestBody PlanDTO planDTO) {
        PlanDTO updatedPlan = planService.update(planDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("updatedPlan", updatedPlan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        planService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
