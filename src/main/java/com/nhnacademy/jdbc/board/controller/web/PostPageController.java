package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.service.PostService;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
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

    @GetMapping(value = {"/contextPost"})
    public String postPage(HttpServletRequest request) {
        Optional<Post> post = postService.getPost(1);
        request.setAttribute("post", post.get());
        return "index/contextPost";
    }

    @PostMapping("/infoPost")
    public String infoPost() {

        if()

        return "/infoPost";
    }

    @PostMapping("/modifyPost")
    public String modifyPost() {
        return "/";
    }

    @GetMapping("/removePost")
    public String removePostForm() {
        return "index/removePost";
    }

    @GetMapping("/registerPost")
    public String registerPostForm() {
        return  "index/registerPost";
    }

    @GetMapping("/modifyPost")
    public String modifyPostForm() {
        return "index/modifyPost";
    }

    @GetMapping(value = "/infoPost")
    public String infoPostForm() {
        return "index/infoPost";
    }
}
