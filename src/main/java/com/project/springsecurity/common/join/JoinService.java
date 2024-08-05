package com.project.springsecurity.common.join;

import com.project.springsecurity.admin.repository.AdminRepository;
import com.project.springsecurity.member.dto.MemberRequestDTO;
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
    public String addUser(MemberRequestDTO userInfo){
        return memberRepository.save(userInfo.toEntity(passwordEncoder)).getUsername();
    }

    public String addAdminUser(MemberRequestDTO userInfo){
        memberRepository.save(userInfo.toEntity(passwordEncoder));
        return adminRepository.save(userInfo.toAdminEntity(passwordEncoder)).getUserId();
    }
}
