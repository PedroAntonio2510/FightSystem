package br.com.FightSystem.service;

import br.com.FightSystem.domain.dto.MemberDTO;
import br.com.FightSystem.domain.member.Member;
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

    public List<MemberDTO> findAll() {
        return memberRepository.findAll().stream().map(MemberMapper::map).toList();
    }

    public MemberDTO findById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(null);
        return MemberMapper.map(member);
    }

    public MemberDTO save(MemberDTO member) {
        Member memberSaved = memberRepository.save(MemberMapper.map(member));
        return MemberMapper.map(memberSaved);
    }

    public MemberDTO update(MemberDTO memberDTO, Long id) {
        memberRepository.findById(id).orElseThrow(null);
        Member updatedMember = MemberMapper.map(memberDTO);
        updatedMember.setId(id);
        Member savedMember = memberRepository.save(updatedMember);
        return MemberMapper.map(savedMember);
    }

    public void deleteById(Long id) {
        memberRepository.findById(id)
                .orElseThrow(null);
        memberRepository.deleteById(id);
    }
}
