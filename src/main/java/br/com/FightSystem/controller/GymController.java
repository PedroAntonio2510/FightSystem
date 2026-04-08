package br.com.FightSystem.controller;

import br.com.FightSystem.dto.GymDTO;
import br.com.FightSystem.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gyms")
public class GymController {

    @Autowired
    private GymService gymService;

    @PostMapping
    public ResponseEntity<GymDTO> createGym(@RequestBody GymDTO gymDTO) {
        return ResponseEntity.ok(gymService.createGym(gymDTO));
    }

    @GetMapping
    public ResponseEntity<List<GymDTO>> getAllGyms() {
        return ResponseEntity.ok(gymService.getAllGyms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GymDTO> getGymById(@PathVariable Long id) {
        GymDTO gymDTO = gymService.getGymById(id);
        return gymDTO != null ? ResponseEntity.ok(gymDTO) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GymDTO> updateGym(@PathVariable Long id, @RequestBody GymDTO gymDTO) {
        GymDTO updatedGym = gymService.updateGym(id, gymDTO);
        return updatedGym != null ? ResponseEntity.ok(updatedGym) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGym(@PathVariable Long id) {
        gymService.deleteGym(id);
        return ResponseEntity.noContent().build();
    }
}
