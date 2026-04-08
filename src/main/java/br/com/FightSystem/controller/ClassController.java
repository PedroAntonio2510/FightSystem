package br.com.FightSystem.controller;

import br.com.FightSystem.dto.ClassDTO;
import br.com.FightSystem.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping
    public ResponseEntity<ClassDTO> createClass(@RequestBody ClassDTO classDTO) {
        return ResponseEntity.ok(classService.createClass(classDTO));
    }

    @GetMapping
    public ResponseEntity<List<ClassDTO>> getAllClasses() {
        return ResponseEntity.ok(classService.getAllClasses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassDTO> getClassById(@PathVariable Long id) {
        ClassDTO classDTO = classService.getClassById(id);
        return classDTO != null ? ResponseEntity.ok(classDTO) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassDTO> updateClass(@PathVariable Long id, @RequestBody ClassDTO classDTO) {
        ClassDTO updatedClass = classService.updateClass(id, classDTO);
        return updatedClass != null ? ResponseEntity.ok(updatedClass) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return ResponseEntity.noContent().build();
    }
}
