package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.postcomment.domain.PostComment;
import com.nhnacademy.jdbc.board.postcomment.service.CommentService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

        return "index/postPage";
    }

    @GetMapping("/removeComment/{boardNo}")
    public String removeComment(@PathVariable int boardNo) {
        commentService.deleteComment(boardNo);
        return "index/postPage";
    }

    @PostMapping("/modifyComment/{postCommentNo}")
    public String modifyComment(@RequestParam("postCommentText") String postCommentText,
                                    @PathVariable int postCommentNo) {
        commentService.modifyComment(postCommentNo, postCommentText);
        return "/index/postPage";
    }

    @GetMapping("/modifyComment/{postCommentNo}")
    public String modifyCommentForm(@PathVariable int postCommentNo, HttpSession session) {
        session.setAttribute("postCommentNo", postCommentNo);
        return "/index/modifyComment";
    }
}
