package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@Slf4j
public class PostPageController {
    private final PostService postService;

    public PostPageController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = {"/postPage"})
    public String postPage() {
        return "index/postPage";
    }
}
