package br.com.FightSystem.domain;

import br.com.FightSystem.domain.enums.EnrollStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "enrolls")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Enroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "enroll_status")
    @Enumerated(EnumType.STRING)
    private EnrollStatus enrollStatus;


}


