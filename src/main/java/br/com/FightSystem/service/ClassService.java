package br.com.FightSystem.service;

import br.com.FightSystem.domain.ClassModel;
import br.com.FightSystem.dto.ClassDTO;
import br.com.FightSystem.mapper.ClassMapper;
import br.com.FightSystem.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public ClassDTO createClass(ClassDTO classDTO) {
        ClassModel classModel = ClassMapper.toModel(classDTO);
        classModel = classRepository.save(classModel);
        return ClassMapper.toDTO(classModel);
    }

    public List<ClassDTO> getAllClasses() {
        return classRepository.findAll().stream()
                .map(ClassMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClassDTO getClassById(Long id) {
        return classRepository.findById(id)
                .map(ClassMapper::toDTO)
                .orElse(null);
    }

    public ClassDTO updateClass(Long id, ClassDTO classDTO) {
        return classRepository.findById(id)
                .map(classModel -> {
                    classModel.setName(classDTO.name());
                    classModel.setClassType(classDTO.classType());
                    classModel.setStartTime(classDTO.startTime());
                    classModel = classRepository.save(classModel);
                    return ClassMapper.toDTO(classModel);
                })
                .orElse(null);
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}
