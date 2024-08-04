package com.project.springsecurity.common.join;

import com.project.springsecurity.admin.dto.AdminRequestDTO;
import com.project.springsecurity.admin.repository.AdminRepository;
import com.project.springsecurity.member.dto.RequestDTO;
import com.project.springsecurity.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final MemberRepository memberRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    public String addUser(RequestDTO userInfo){
        return memberRepository.save(userInfo.toEntity(passwordEncoder)).getUsername();
    }

    public String addAdminUser(AdminRequestDTO userInfo){
        return adminRepository.save(userInfo.toEntity(passwordEncoder)).getUsername();
    }
}
