package com.project.springsecurity.common.join;

import com.project.springsecurity.admin.dto.AdminRequestDTO;
import com.project.springsecurity.member.dto.RequestDTO;
import com.project.springsecurity.member.Role;
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
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setRole(Role.USER);
        model.addAttribute("requestDTO",requestDTO);
        return "join/join";
    }

    @PostMapping("/user")
    public String join(RequestDTO userInfo){
        joinService.addUser(userInfo);
        return "login/login";
    }

    @GetMapping("/admin")
    public String adminJoin(Model model){
        AdminRequestDTO adminRequestDTO = new AdminRequestDTO();
        adminRequestDTO.setRole(Role.ADMIN);
        model.addAttribute("requestDTO",adminRequestDTO);
        return "join/join";
    }

    @PostMapping("/admin")
    public String adminJoin(AdminRequestDTO userInfo){
        joinService.addAdminUser(userInfo);
        return "login/login";
    }
}
