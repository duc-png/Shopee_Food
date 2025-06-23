package com.example.shopeefood.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String password;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Size(max = 15)
    @Column(length = 15)
    private String phone;

    @Column
    private String provider;

    @Column
    private String providerId;

    @NotNull
    @Column(nullable = false)
    private Boolean isActive = true;

    @Column
    private String avatarURL;

    @Column
    private java.sql.Timestamp createdAt;

    @Column
    private java.sql.Timestamp lastLogin;

    // Relationships
    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles;

    @OneToMany(mappedBy = "user")
    private List<AuditLog> auditLogs;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    @OneToMany(mappedBy = "user")
    private List<FavoriteProduct> favoriteProducts;

    @OneToMany(mappedBy = "user")
    private List<FavoriteShop> favoriteShops;

    @OneToMany(mappedBy = "user")
    private List<PurchaseHistory> purchaseHistories;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @OneToMany(mappedBy = "user")
    private List<UserVoucher> userVouchers;

    @OneToMany(mappedBy = "owner")
    private List<Shop> ownedShops;

    @OneToMany(mappedBy = "shipper")
    private List<Shipment> shipments;

    @OneToMany(mappedBy = "shipper")
    private List<ShipperPayout> shipperPayouts;
}