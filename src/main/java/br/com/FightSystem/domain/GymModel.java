package br.com.FightSystem.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "gyms")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GymModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;
    private String address;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
