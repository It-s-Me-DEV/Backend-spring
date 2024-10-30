package me.shinsunyoung.springbootdeveloper.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.dto.AddUserRequest;
import me.shinsunyoung.springbootdeveloper.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController { // 폼에서 회원가입 서비스 요청을 받으면 사용자를 저장한 뒤, 로그인 페이지로 이동하는 signup 메서드 작성

    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request) {
        userService.save(request); // 회원가입 메서드 호출
        return "redirect:/login"; // 회원 가입 완료 시 로그인 페이지로 이동
    }

    @GetMapping("/logout") // /logout Get 요청을 하면 로그아웃을 담당하는 핸들러인 SecurityContextLogoutHandler의 logout() 메서드를 호출해 로그아웃
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/logoin"; // 로그아웃 완료 시 로그인 페이지로 이동
    }
}
