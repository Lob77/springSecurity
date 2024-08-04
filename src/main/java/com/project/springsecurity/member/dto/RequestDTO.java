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
public class RequestDTO {
    private Long id;
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
                .password(passwordEncoder.encode(password))
                .role(Role.USER)
                .build();
    }
}
