package br.com.FightSystem.controller;

import br.com.FightSystem.dto.GymDTO;
import br.com.FightSystem.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gyms")
public class GymController {

    private final GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @PostMapping
    public ResponseEntity<GymDTO> createGym(@RequestBody GymDTO gymDTO) {
        GymDTO gym = gymService.createGym(gymDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(gym);
    }

    @GetMapping
    public ResponseEntity<List<GymDTO>> getAllGyms() {
        return ResponseEntity.ok(gymService.getAllGyms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GymDTO> getGymById(@PathVariable Long id) {
        GymDTO gymDTO = gymService.getGymById(id);
        return ResponseEntity.ok(gymDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GymDTO> updateGym(@PathVariable Long id, @RequestBody GymDTO gymDTO) {
        GymDTO updatedGym = gymService.updateGym(id, gymDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedGym);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGym(@PathVariable Long id) {
        gymService.deleteGym(id);
        return ResponseEntity.noContent().build();
    }
}
