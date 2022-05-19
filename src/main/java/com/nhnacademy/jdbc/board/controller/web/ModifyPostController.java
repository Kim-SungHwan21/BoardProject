package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modifyPost")
@Slf4j
public class ModifyPostController {

    private final PostService postService;

    public ModifyPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public String modifyPostForm() {
        return "index/modifyPost";
    }

    @PostMapping()
    public String modifyPost() {} // TODO : 게시글 수정 Post
}
