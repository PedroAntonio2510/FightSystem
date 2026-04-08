package br.com.FightSystem.repository;

import br.com.FightSystem.domain.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberModel, Long> {
    boolean existsByCpf(String cpf);
}
