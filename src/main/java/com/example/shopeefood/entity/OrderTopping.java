package com.example.shopeefood.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_toppings", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"orderItemID", "toppingID"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderTopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderToppingID;

    @ManyToOne
    @JoinColumn(name = "orderItemID")
    private OrderItem orderItem;

    @ManyToOne
    @JoinColumn(name = "toppingID")
    private ProductTopping productTopping;
}