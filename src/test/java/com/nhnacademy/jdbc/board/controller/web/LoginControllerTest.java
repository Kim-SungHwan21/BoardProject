package com.nhnacademy.jdbc.board.controller.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.member.service.MemberLoginService;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.NestedServletException;

class LoginControllerTest {
    private MockMvc mockMvc;
    private MemberLoginService memberLoginService;
    private Member member;

    @BeforeEach
    void setUp() {
        memberLoginService = mock(MemberLoginService.class);
        member = mock(Member.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new LoginController(memberLoginService))
            .build();
    }

    @Test
    void login() throws Exception {
        mockMvc.perform(get("/login"))
            .andExpect(status().isOk())
            .andExpect(view().name("index/loginForm"));
    }

    @Test
    void dologinIsSuccessful() throws Exception {
        when(memberLoginService.doLogin(anyString(), anyString()))
            .thenReturn(Optional.of(member));

        MvcResult mvcResult = mockMvc.perform(post("/login")
                .param("memId", "admin")
                .param("password", "admin"))
            .andExpect(status().isOk())
            .andExpect(view().name("index/loginSuccess"))
            .andReturn();

        HttpSession httpSession = mvcResult.getRequest().getSession(false);
        assertThat(httpSession.getAttribute("member")).isEqualTo(member);
    }

    @Test
    void dologinIsNotSuccessful() throws Exception {
        when(memberLoginService.doLogin(anyString(), anyString()))
            .thenReturn(Optional.empty());

        MvcResult mvcResult = mockMvc.perform(post("/login")
                .param("memId", "admin")
                .param("password", "12345"))
            .andExpect(status().is5xxServerError())
            .andExpect(view().name("index/longin"))
            .andReturn();

        HttpSession httpSession = mvcResult.getRequest().getSession(false);
        assertThat(httpSession.getAttribute("member")).isNull();
    }
}