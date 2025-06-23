package com.example.shopeefood.entity;

import com.example.shopeefood.model.enums.PaymentMethod;
import com.example.shopeefood.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentID;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private PaymentStatus paymentStatus = PaymentStatus.Pending;

    @Column
    private java.sql.Timestamp paymentDate;

    @ManyToOne
    @JoinColumn(name = "orderID")
    private Order order;

}