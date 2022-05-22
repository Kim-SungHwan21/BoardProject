package com.nhnacademy.jdbc.board.controller.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.nhnacademy.jdbc.board.member.service.MemberLoginService;
import com.nhnacademy.jdbc.board.post.service.PostService;
import com.nhnacademy.jdbc.board.postcomment.service.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class PostPageControllerTest {
    private MockMvc mockMvc;

    private PostService postService;
    private CommentService commentService;

    @BeforeEach
    void setUp() {
        postService = mock(PostService.class);
        commentService = mock(CommentService.class);

        mockMvc = MockMvcBuilders.standaloneSetup(new PostPageController(postService, commentService))
            .build();
    }

    @Test
    void modifyPostForm() {

    }

    @Test
    void modifyPost() {
    }

    @Test
    void contextPost() {
    }

    @Test
    void registerPost() {
    }

    @Test
    void listPostForm() {
    }

    @Test
    void removePostForm() {
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