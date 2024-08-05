package com.project.springsecurity.common.join;

import com.project.springsecurity.member.Role;
import com.project.springsecurity.member.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/join")
@Slf4j
public class JoinContoller {

    private final JoinService joinService;

    @GetMapping("/user")
    public String join(Model model){
        MemberRequestDTO requestDTO = new MemberRequestDTO();
        requestDTO.setRole(Role.USER);
        model.addAttribute("requestDTO",requestDTO);
        return "join/join";
    }

    @PostMapping("/user")
    public String join(MemberRequestDTO userInfo){
        userInfo.setRole(Role.USER);
        joinService.addUser(userInfo);
        return "login/login";
    }

    @GetMapping("/admin")
    public String adminJoin(Model model){
        MemberRequestDTO requestDTO = new MemberRequestDTO();
        requestDTO.setRole(Role.ADMIN);
        model.addAttribute("requestDTO",requestDTO);
        return "join/join";
    }

    @PostMapping("/admin")
    public String adminJoin(MemberRequestDTO userInfo){
        userInfo.setRole(Role.ADMIN);
        joinService.addAdminUser(userInfo);
        return "login/login";
    }
}
