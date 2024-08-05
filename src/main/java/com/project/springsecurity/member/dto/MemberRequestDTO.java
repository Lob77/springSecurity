package com.project.springsecurity.member.dto;

import com.project.springsecurity.admin.Admin;
import com.project.springsecurity.member.Member;
import com.project.springsecurity.member.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@RequiredArgsConstructor
public class MemberRequestDTO {
    private String userId;
    private String password;
    private Role role;
    private String userName;
    private String companyName;
    private String companyCode;


    public Member toEntity(PasswordEncoder passwordEncoder){
        return Member.builder()
                .userId(userId)
                .username(userName)
                .role(role)
                .password(passwordEncoder.encode(password))
                .build();
    }

    public Admin toAdminEntity(PasswordEncoder passwordEncoder){
        return Admin.builder()
                .userId(userId)
                .companyCode(companyCode)
                .companyName(companyName)
                .build();
    }
}
