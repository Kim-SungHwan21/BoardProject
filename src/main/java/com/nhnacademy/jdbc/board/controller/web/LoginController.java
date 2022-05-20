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
//        Optional<Member> member = memberLoginService.getMember(1);
//        if(member.isPresent()) {
//            log.debug("member : {}", member.get());
//        }
        return "index/loginForm";
    }

    @PostMapping(value = "/login")
    public String doLogin(@RequestParam("memId") String memId,
                          @RequestParam("password") String password,
                          HttpServletRequest request,
                          HttpServletResponse response) {

        if (memberLoginService.isLogin(memId, password)) {
            HttpSession session = request.getSession(true);

            Cookie cookie = new Cookie("SESSION", session.getId());
            response.addCookie(cookie);

            return "index/loginSuccess";
        } else {
            return "index/longinForm";
        }
//
//        if(memberLoginService.matches(memId, password)) {
//            return "index/loginSuccess";
//        } else {
//            return "index/longinForm";
//        }
    }
}
