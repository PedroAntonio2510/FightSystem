package br.com.FightSystem.repository;

import br.com.FightSystem.domain.EnrollModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollRepository extends JpaRepository<EnrollModel, Long> {
}
