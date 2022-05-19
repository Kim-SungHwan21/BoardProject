package com.nhnacademy.jdbc.board.controller.web;


import com.nhnacademy.jdbc.board.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@Slf4j
public class InfoPostController {

    private final PostService postService;

    public InfoPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/infoPost")
    public String infoPost() {
        return "index/infoPost";
    }

}
