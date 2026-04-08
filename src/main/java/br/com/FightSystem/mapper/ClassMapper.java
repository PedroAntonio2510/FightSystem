package br.com.FightSystem.mapper;

import br.com.FightSystem.domain.ClassModel;
import br.com.FightSystem.domain.GymModel;
import br.com.FightSystem.dto.ClassDTO;
import org.springframework.stereotype.Component;


public class ClassMapper {

    public static ClassDTO toDTO(ClassModel classModel) {
        return ClassDTO.builder()
                .id(classModel.getId())
                .name(classModel.getName())
                .classType(classModel.getClassType())
                .startTime(classModel.getStartTime())
                .gymId(classModel.getGymModel() != null ? classModel.getGymModel().getId() : null)
                .build();
    }

    public static ClassModel toModel(ClassDTO classDTO) {
        ClassModel classModel = ClassModel.builder()
                .id(classDTO.id())
                .name(classDTO.name())
                .classType(classDTO.classType())
                .startTime(classDTO.startTime())
                .build();

        if (classDTO.gymId() != null) {
            classModel.setGymModel(GymModel.builder().id(classDTO.gymId()).build());
        }

        return classModel;
    }
}
