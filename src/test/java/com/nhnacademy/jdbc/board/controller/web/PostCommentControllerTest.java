package com.nhnacademy.jdbc.board.controller.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import com.nhnacademy.jdbc.board.post.service.PostService;
import com.nhnacademy.jdbc.board.postcomment.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class PostCommentControllerTest {
    private MockMvc mockMvc;

    private CommentService commentService;

    void setUp() {
        commentService = mock(CommentService.class);

        mockMvc = MockMvcBuilders.standaloneSetup(new PostCommentController(commentService))
            .build();
    }

    @Test
    void registerComment() {
    }

    @Test
    void removeComment() {
    }

    @Test
    void modifyComment() {
    }

    @Test
    void modifyCommentForm() {
    }
}