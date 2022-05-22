package com.nhnacademy.jdbc.board.controller.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.nhnacademy.jdbc.board.post.service.PostService;
import com.nhnacademy.jdbc.board.postcomment.service.CommentService;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class PostCommentControllerTest {
    private MockMvc mockMvc;

    private CommentService commentService;

    @BeforeEach
    void setUp() {
        commentService = mock(CommentService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new PostCommentController(commentService))
            .build();
        MockHttpSession session = new MockHttpSession();
    }

    @DisplayName("댓글 작성 성공")
    @Test
    void sucessRegisterComment() throws Exception {
        when(commentService.getAllComments().size() + anyInt()).thenReturn(1);
        mockMvc.perform(post("/registerComment/1")
                .param("가나다라마바사"))
            .andExpect(status().isOk())
            .andExpect(view().name("index/postPage"))
            .andReturn();

        verify(commentService).registerComment(anyInt(), null,
            anyInt(), anyInt(), anyInt(), anyString(), anyString(), new Date());
    }



    @DisplayName("댓글 삭제 성공")
    @Test
    void removeCommentTest() throws Exception {
        mockMvc.perform(get("/removeComment/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("index/postPage"));

        verify(commentService).deleteComment(anyInt());
    }

    @Test
    void modifyComment() {

    }

    @DisplayName("댓글 수정 창 이동")
    @Test
    void getMappingModifyCommentTest() throws Exception {
        mockMvc.perform(get("/modifyComment/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("/index/modifyComment"));
    }
}