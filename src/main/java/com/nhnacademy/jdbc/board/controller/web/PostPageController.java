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

    @GetMapping("/removePost")
    public String removePost() {
        return "index/removePost";
    }

    @GetMapping("/registerPost")
    public String registerPost() {
        return  "index/registerPost";
    }

    @GetMapping("/modifyPost")
    public String modifyPostForm() {
        return "index/modifyPost";
    }

    @GetMapping(value = "/infoPost")
    public String infoPost() {
        return "index/infoPost";
    }


}
