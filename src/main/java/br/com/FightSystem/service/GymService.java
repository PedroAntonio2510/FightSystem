package br.com.FightSystem.service;

import br.com.FightSystem.domain.GymModel;
import br.com.FightSystem.dto.GymDTO;
import br.com.FightSystem.mapper.GymMapper;
import br.com.FightSystem.repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GymService {

    @Autowired
    private GymRepository gymRepository;

    public GymDTO createGym(GymDTO gymDTO) {
        GymModel gymModel = GymMapper.toModel(gymDTO);
        gymModel = gymRepository.save(gymModel);
        return GymMapper.toDTO(gymModel);
    }

    public List<GymDTO> getAllGyms() {
        return gymRepository.findAll().stream()
                .map(GymMapper::toDTO)
                .collect(Collectors.toList());
    }

    public GymDTO getGymById(Long id) {
        return gymRepository.findById(id)
                .map(GymMapper::toDTO)
                .orElse(null);
    }

    public GymDTO updateGym(Long id, GymDTO gymDTO) {
        return gymRepository.findById(id)
                .map(gymModel -> {
                    gymModel.setName(gymDTO.name());
                    gymModel.setAddress(gymDTO.address());
                    gymModel = gymRepository.save(gymModel);
                    return GymMapper.toDTO(gymModel);
                })
                .orElse(null);
    }

    public void deleteGym(Long id) {
        gymRepository.deleteById(id);
    }
}
