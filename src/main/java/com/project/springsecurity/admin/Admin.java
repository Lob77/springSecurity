package com.project.springsecurity.admin;

import com.project.springsecurity.member.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String companyCode;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Admin(String userId, String username, String password, Role role, String companyName, String companyCode){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.companyName = companyName;
        this.companyCode = companyCode;
    }
}
