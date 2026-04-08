package br.com.FightSystem.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "gyms")
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;
    private String address;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
