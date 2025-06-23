package com.example.shopeefood.entity;

import com.example.shopeefood.model.enums.TokenType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "tokens")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenID;

    @NotBlank
    @Column(nullable = false, length = 512)
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private TokenType tokenType = TokenType.ACCESS;

    @Column
    private java.sql.Timestamp issuedAt;

    @Column
    private java.sql.Timestamp expiresAt;

    @Column
    private Boolean revoked = false;

    @Column
    private String deviceInfo;

    @Column
    private String ipAddress;

    @Column
    private String userAgent;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

}