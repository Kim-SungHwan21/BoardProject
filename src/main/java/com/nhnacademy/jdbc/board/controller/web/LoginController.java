package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.member.service.MemberLoginService;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        Optional<Member> member = memberLoginService.getMember(1); // TODO :
        if(member.isPresent()) {
            log.debug("member : {}", member.get());
        }
        return "index/loginForm";
    }
}
