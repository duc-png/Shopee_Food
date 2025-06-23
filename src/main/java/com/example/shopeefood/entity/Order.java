package com.example.shopeefood.entity;

import com.example.shopeefood.model.enums.OrderStatus;
import com.example.shopeefood.model.enums.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderID;

    @NotNull
    @Column(nullable = false)
    private java.math.BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private OrderStatus status = OrderStatus.Pending;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private PaymentStatus paymentStatus = PaymentStatus.Pending;

    @Column
    private String deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "order")
    private List<Payment> payments;

    @OneToMany(mappedBy = "order")
    private List<Shipment> shipments;

    @OneToMany(mappedBy = "order")
    private List<PurchaseHistory> purchaseHistories;

    @OneToMany(mappedBy = "order")
    private List<ShopPayout> shopPayouts;

    @OneToMany(mappedBy = "order")
    private List<ShipperPayout> shipperPayouts;

}