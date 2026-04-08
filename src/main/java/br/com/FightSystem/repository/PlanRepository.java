package br.com.FightSystem.repository;

import br.com.FightSystem.domain.PlanModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<PlanModel, Long> {
}
