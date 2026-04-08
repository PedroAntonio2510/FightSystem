package br.com.FightSystem.repository;

import br.com.FightSystem.domain.GymModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends JpaRepository<GymModel, Long> {
}
