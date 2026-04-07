package br.com.FightSystem.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(length = 155)
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(length = 20)
    private String belt;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Member() {
    }

    public Member(Long id, String name, String cpf, String email, LocalDate birthDate, String belt, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birthDate = birthDate;
        this.belt = belt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Member(Long id, String name, String cpf, String email, LocalDate birthDate, String belt) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birthDate = birthDate;
        this.belt = belt;
    }


    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBelt() {
        return belt;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static class MemberBuilder {
        private Long id;
        private String name;
        private String cpf;
        private String email;
        private LocalDate birthDate;
        private String belt;

        public MemberBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MemberBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MemberBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }
        public MemberBuilder email(String email) {
            this.email = email;
            return this;
        }

        public MemberBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }
        public MemberBuilder belt(String belt) {
            this.belt = belt;
            return this;
        }

        public Member build() {
            return new Member(id, name, cpf, email, birthDate, belt);
        }
    }
}
