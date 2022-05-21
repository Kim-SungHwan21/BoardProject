package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.postcomment.domain.PostComment;
import com.nhnacademy.jdbc.board.postcomment.service.CommentService;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
@Slf4j
public class PostCommentController {
    private final CommentService commentService;

    public PostCommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/registerComment/{boardNo}")
    public String registerComment(@RequestParam("CommentText") String postCommentText, @PathVariable int boardNo, Model model, HttpSession session) {
        int size = commentService.getAllComments().size() + 1;
        model.addAttribute("size", size);
        Member member = (Member) session.getAttribute("member");
        commentService.registerComment(size, null, member.getMemNo(),
            boardNo, 1, String.valueOf(size), postCommentText, new Date());

        return "index/contextPost";
    }
}
