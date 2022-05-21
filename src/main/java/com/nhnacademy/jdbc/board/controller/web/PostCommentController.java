package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.postcomment.service.CommentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class PostCommentController {
    private final CommentService commentService;

    public PostCommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/registerComment/{boardNo}/{boardCommentCount}")
    public String registerComment(@PathVariable int boardNo, @PathVariable int boardCommentCount) {
        
        return "index/contextPost/{boardNo}";
    }
}
