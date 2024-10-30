package me.shinsunyoung.springbootdeveloper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController { // 로그인, 회원가입 경로로 접근하면 뷰 파일을 연결하는 컨트롤러
    @GetMapping("/login")
    public String login() {
        return "login"; // /login 경로로 접근하면 login.html을 반환
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup"; // signup 경로로 접근하면 signup.html을 반환
    }
}
