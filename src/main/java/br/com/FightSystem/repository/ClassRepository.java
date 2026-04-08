package br.com.FightSystem.repository;

import br.com.FightSystem.domain.ClassModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassModel, Long> {
}
