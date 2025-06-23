package com.example.shopeefood.entity;

import com.example.shopeefood.model.enums.StatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "statistics")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statID;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private StatType statType;

    @Column
    private Integer weekOfYear;

    @Column
    private Integer monthOfYear;

    @Column
    private Integer total;

    @Column
    private java.math.BigDecimal avgRating;

    @Column
    private String details;

    @Column
    private java.sql.Timestamp statDate;

}