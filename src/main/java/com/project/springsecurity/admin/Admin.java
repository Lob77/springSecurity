package com.project.springsecurity.admin;

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
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String companyCode;



    @Builder
    public Admin(String userId, String companyName, String companyCode){
        this.userId = userId;
        this.companyName = companyName;
        this.companyCode = companyCode;
    }
}
