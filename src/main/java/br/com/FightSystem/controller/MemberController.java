package br.com.FightSystem.controller;

import br.com.FightSystem.domain.dto.MemberDTO;
import br.com.FightSystem.domain.member.Member;
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
        return ResponseEntity.ok(Map.of("members",
                memberService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> findById(@PathVariable Long id) {
        MemberDTO memberFound = memberService.findById(id);
        return ResponseEntity.ok(memberFound);
    }

    @PostMapping
    public ResponseEntity<MemberDTO> save(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok(memberService.save(memberDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, MemberDTO>> update(@RequestBody MemberDTO memberDTO, @PathVariable Long id) {
        MemberDTO updatedMember = memberService.update(memberDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("updatedMember", updatedMember));
    }
}
