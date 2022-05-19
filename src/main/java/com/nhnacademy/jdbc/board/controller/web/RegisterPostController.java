package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registerPost")
@Slf4j
public class RegisterPostController {
    private final PostService postService;

    public RegisterPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String registerPost() {
        return  "index/registerPost";
    }
}
