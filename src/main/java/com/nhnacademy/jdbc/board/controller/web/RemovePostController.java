package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/removePost")
@Slf4j
public class RemovePostController {
    private final PostService postService;

    public RemovePostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String removePost() {
        return "index/removePost";
    }
}
