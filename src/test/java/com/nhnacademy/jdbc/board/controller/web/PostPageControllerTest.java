package com.nhnacademy.jdbc.board.controller.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.member.service.MemberLoginService;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.service.PostService;
import com.nhnacademy.jdbc.board.postcomment.service.CommentService;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class PostPageControllerTest {
    private MockMvc mockMvc;
    private Member member;
    private Post post;
    private MockHttpSession session;
    private PostService postService;
    private CommentService commentService;
    private Date date;
    @BeforeEach
    void setUp() {
        session = new MockHttpSession();
        postService = mock(PostService.class);
        commentService = mock(CommentService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new PostPageController(postService, commentService))
            .build();
        member = new Member();
        member.setMemNo(10);
        member.setMemId("admin");
        member.setMemPassword("admin");
        session.setAttribute("member", member);
        date = new Date();
        post = new Post();
        post.setBoardNo(1);
        post.setParentsBoardNo(null);
        post.setMemNo(10);
        post.setBoardDepth(1);
        post.setBoardLevelNo("1");
        post.setBoardTitle("boardTitle");
        post.setBoardContext("boardContext");
        post.setBoardRegisterDatetime(date);
        post.setBoardModifyDatetime(date);
        post.setBoardCommentCount(1);
        post.setBoardViewCount(1);
        post.setBoardDeleteCheck(false);
    }

    @Test
    void modifyPostForm() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/modifyPost/1"))
            .andExpect(status().isOk())
            .andExpect(model().attribute("post", postService.getPost(1).get()))
            .andDo(print())
            .andExpect(view().name("index/modifyPost"))
            .andReturn();

        assertThat(mvcResult.getModelAndView().getModelMap().getAttribute("post"))
            .isEqualTo(postService.getPost(1));

    }

//    @Test
//    void modifyPost() {
//    }

    @Test
    void contextPost() {
    }

    @Test
    void listPostForm() {
    }

    @Test
    void removePostForm() {
    }

    @Test
    void registerPost() {
    }

    @Test
    void registerPostForm() {
    }

    @Test
    void postPage() throws Exception {
        mockMvc.perform(get("/postPage"))
            .andExpect(status().isOk())
            .andExpect(view().name("index/postPage"));
    }
}