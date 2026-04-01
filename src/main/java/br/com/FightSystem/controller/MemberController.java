package br.com.FightSystem.controller;

import br.com.FightSystem.domain.Member;
import br.com.FightSystem.dto.MemberDTO;
import br.com.FightSystem.mapper.MemberMapper;
import br.com.FightSystem.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<Map<String, List<MemberDTO>>> findAll() {
        List<MemberDTO> members = memberService.findAll().stream().map(MemberMapper::map).toList();
        return ResponseEntity.ok(Map.of("members",
                members));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> findById(@PathVariable Long id) {
        Member memberFound = memberService.findById(id);
        return ResponseEntity.ok(MemberMapper.map(memberFound));
    }

    @PostMapping
    public ResponseEntity<MemberDTO> save(@RequestBody MemberDTO memberDTO) {
        Member savedMember = memberService.save(memberDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(MemberMapper.map(savedMember));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, MemberDTO>> update(@RequestBody MemberDTO memberDTO, @PathVariable Long id) {
        Member updatedMember = memberService.update(memberDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("updatedMember", MemberMapper.map(updatedMember)));
    }
}
