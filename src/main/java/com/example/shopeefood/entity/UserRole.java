package com.example.shopeefood.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "user_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userRoleID;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "roleID", nullable = false)
    private Role role;
}