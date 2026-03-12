package br.com.FightSystem.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(scale = 2, precision = 10)
    private BigDecimal price;

    private String description;

    @Column(name = "month_duration")
    private Integer monthDuration;

    public Plan(Long id, String name, BigDecimal price, String description, Integer monthDuration) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.monthDuration = monthDuration;
    }

    public Plan() {
        
    }

    public static PlanBuilder builder() {
        return new PlanBuilder();
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMonthDuration() {
        return monthDuration;
    }

    public void setMonthDuration(Integer monthDuration) {
        this.monthDuration = monthDuration;
    }

    public static class PlanBuilder {
        private Long id;
        private String name;
        private BigDecimal price;
        private String description;
        private Integer monthDuration;

        public PlanBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PlanBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlanBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public PlanBuilder description(String description) {
            this.description = description;
            return this;
        }

        public PlanBuilder monthDuration(Integer monthDuration) {
            this.monthDuration = monthDuration;
            return this;
        }

        public Plan build() {
            return new Plan(id, name, price, description, monthDuration);
        }
    }
}
