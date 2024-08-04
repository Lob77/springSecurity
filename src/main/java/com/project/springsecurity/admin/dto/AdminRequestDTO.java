package com.project.springsecurity.admin.dto;

import com.project.springsecurity.admin.Admin;
import com.project.springsecurity.member.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@RequiredArgsConstructor
public class AdminRequestDTO {
    private Long id;
    private String userId;
    private String password;
    private Role role;
    private String userName;
    private String companyName;
    private String companyCode;


    public Admin toEntity(PasswordEncoder passwordEncoder){
        return Admin.builder()
                .userId(userId)
                .username(userName)
                .password(passwordEncoder.encode(password))
                .role(Role.ADMIN)
                .companyName(companyName)
                .companyCode(companyCode)
                .build();
    }
}
