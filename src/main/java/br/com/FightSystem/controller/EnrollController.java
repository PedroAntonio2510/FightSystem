package br.com.FightSystem.controller;

import br.com.FightSystem.dto.EnrollDTO;
import br.com.FightSystem.mapper.EnrollMapper;
import br.com.FightSystem.service.EnrollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/enroll")
public class EnrollController {

    private final EnrollService enrollService;

    public EnrollController(EnrollService enrollService) {
        this.enrollService = enrollService;
    }

    @GetMapping
    public ResponseEntity<Map<String, List<EnrollDTO>>> findAll() {
        List<EnrollDTO> enrolls = enrollService.findAll();
        return ResponseEntity.ok(Map.of("enrolls", enrolls));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EnrollDTO> save(@RequestBody EnrollDTO enrollDTO) {
        EnrollDTO enroll = enrollService.save(enrollDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(enroll);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Optional<EnrollDTO>>> update(@PathVariable Long id, @RequestBody EnrollDTO enrollDTO) {
        Optional<EnrollDTO> updatedEnroll = enrollService.update(id, EnrollMapper.map(enrollDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("updatedEnroll", updatedEnroll));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        enrollService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
