package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.member.service.MemberLoginService;
import java.util.Optional;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
@Slf4j
public class LoginController {
    private final MemberLoginService memberLoginService;

    public LoginController(MemberLoginService memberLoginService) {
        this.memberLoginService = memberLoginService;
    }

    @GetMapping(value = {"/login"})
    public String login() {
        return "index/loginForm";
    }

    @PostMapping(value = "/login")
    public String doLogin(@RequestParam("memId") String memId,
                          @RequestParam("password") String password,
                          HttpSession session) {

        Optional<Member> member = memberLoginService.doLogin(memId, password);
        if (member.isPresent()) {
            session.setAttribute("member", member.get());
            return "index/loginSuccess";
        } else {
            return "index/longinForm";
        }
    }
}
