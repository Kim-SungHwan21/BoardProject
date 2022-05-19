package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@Slf4j
public class ModifyPostController {

    private final PostService postService;

    public ModifyPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/modifyPost")
    public String modifyPost() {
        return "index/modifyPost";
    }
}
