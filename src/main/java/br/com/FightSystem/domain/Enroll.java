package br.com.FightSystem.domain;

import br.com.FightSystem.domain.member.Member;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "enroll")
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

    private boolean enrolled;

    public Enroll() {
    }

    public Enroll(Long id, Plan plan, Member member, boolean enrolled) {
        this.id = id;
        this.plan = plan;
        this.member = member;
        this.enrolled = enrolled;
    }

    public static EnrollBuilder builder() {
        return new EnrollBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    public static class EnrollBuilder {
        private Long id;
        private Plan plan;
        private Member member;
        private boolean enrolled;

        public EnrollBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public EnrollBuilder plan(Plan plan) {
            this.plan = plan;
            return this;
        }

        public EnrollBuilder member(Member member) {
            this.member = member;
            return this;
        }

        public EnrollBuilder enrolled(boolean enrolled) {
            this.enrolled = enrolled;
            return this;
        }

        public Enroll build() {
            return new Enroll(id, plan, member, enrolled);
        }
    }
}


