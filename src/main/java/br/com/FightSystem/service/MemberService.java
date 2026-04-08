package br.com.FightSystem.service;

import br.com.FightSystem.dto.MemberDTO;
import br.com.FightSystem.domain.MemberModel;
import br.com.FightSystem.mapper.MemberMapper;
import br.com.FightSystem.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberModel> findAll() {
        return memberRepository.findAll();
    }

    public MemberModel findById(Long id) {
        MemberModel memberModel = memberRepository.findById(id).orElseThrow(null);
        return memberModel;
    }

    public MemberModel save(MemberDTO member) {
        existsByCpf(member.cpf());
        MemberModel memberModelSaved = memberRepository.save(MemberMapper.map(member));
        return memberModelSaved;
    }

    public MemberModel update(MemberDTO memberDTO, Long id) {
        memberRepository.findById(id).orElseThrow(null);
        MemberModel updatedMemberModel = MemberMapper.map(memberDTO);
        updatedMemberModel.setId(id);
        MemberModel savedMemberModel = memberRepository.save(updatedMemberModel);
        return savedMemberModel;
    }

    public void deleteById(Long id) {
        memberRepository.findById(id)
                .orElseThrow(null);
        memberRepository.deleteById(id);
    }

    private boolean existsByCpf(String cpf) {
        if (!memberRepository.existsByCpf(cpf)) {
            return true;
        }
        throw new IllegalArgumentException("Member already exists");
    }
}
