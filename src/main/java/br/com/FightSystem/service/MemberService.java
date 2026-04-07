package br.com.FightSystem.service;

import br.com.FightSystem.dto.MemberDTO;
import br.com.FightSystem.domain.Member;
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

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(null);
        return member;
    }

    public Member save(MemberDTO member) {
        existsByCpf(member.cpf());
        Member memberSaved = memberRepository.save(MemberMapper.map(member));
        return memberSaved;
    }

    public Member update(MemberDTO memberDTO, Long id) {
        memberRepository.findById(id).orElseThrow(null);
        Member updatedMember = MemberMapper.map(memberDTO);
        updatedMember.setId(id);
        Member savedMember = memberRepository.save(updatedMember);
        return savedMember;
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
