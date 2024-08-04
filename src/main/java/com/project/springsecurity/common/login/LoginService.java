package com.project.springsecurity.common.login;

import com.project.springsecurity.admin.Admin;
import com.project.springsecurity.admin.repository.AdminRepository;
import com.project.springsecurity.member.Member;
import com.project.springsecurity.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        try{
            Member member = memberRepository.findByUserId(userId).orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 회원입니다."));
            return User.builder().username(member.getUsername()).password(member.getPassword()).roles(member.getRole().name()).build();
        }catch (Exception e){
            Admin admin = adminRepository.findByUserId(userId).orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 회원입니다."));
            return User.builder().username(admin.getUsername()).password(admin.getPassword()).roles(admin.getRole().name()).build();

        }

    }
}
