package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.member.service.MemberLoginService;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.service.PostService;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
@Slf4j
public class PostPageController {
    private final PostService postService;
    private final MemberLoginService memberLoginService;

    public PostPageController(PostService postService,
                              MemberLoginService memberLoginService) {
        this.postService = postService;
        this.memberLoginService = memberLoginService;
    }


    @PostMapping(value = {"/contextPost"})
    public String contextPost(HttpServletRequest request,
                              @RequestParam("boardNo") int boardNo,
                              @RequestParam("memId") String memId) {
        Optional<Post> post = postService.getPost(boardNo);
        request.setAttribute("post", post.get());
        Optional<Member> member = memberLoginService.getMember(memId);
        request.setAttribute("member", member.get());
        return "index/contextPost";
    }

    @GetMapping(value = "/listPost")
    public String listPostForm(Model model) {
        List<Post> posts = postService.getPosts();
        model.addAttribute("posts", posts);

        return "index/listPost";
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

    @GetMapping(value = "/postPage")
    public String postPage() {
        return "index/postPage";
    }
}
