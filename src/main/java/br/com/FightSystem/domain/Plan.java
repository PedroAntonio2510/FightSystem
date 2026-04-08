package br.com.FightSystem.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "plans")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;

    @Column(scale = 2, precision = 10)
    private BigDecimal price;

    private String description;

    @Column(name = "month_duration")
    private Integer monthDuration;

}
