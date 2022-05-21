package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.member.service.MemberLoginService;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.service.PostService;
import com.nhnacademy.jdbc.board.postcomment.domain.PostComment;
import com.nhnacademy.jdbc.board.postcomment.service.CommentService;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class PostPageController {
    private final PostService postService;
    private final CommentService commentService;

    public PostPageController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/modifyPost/{boardNo}")
    public String modifyPostForm(Model model, @PathVariable int boardNo) {
        model.addAttribute("post", postService.getPost(boardNo).get());
        return "index/modifyPost";
    }

    @PostMapping("/modifyPost/{boardNo}")
    public String modifyPost(@RequestParam("title") String title,
                             @RequestParam("content") String content,
                             @PathVariable int boardNo) {

        postService.modifyPost(boardNo, title, content);
        return "/index/listPost";
    }


    @GetMapping(value = {"/contextPost/{boardNo}"})
    public String contextPost(Model model, @PathVariable int boardNo) {
//        List<Post> posts = postService.getPosts();
        Post post = postService.getPost(boardNo).get();
        model.addAttribute("post", post);
        Member member = postService.getPostWriter(boardNo).get();
        model.addAttribute("member", member);
        List<PostComment> comments = commentService.getComments(boardNo);
        model.addAttribute("comments", comments);
//        List<Member> members = memberLoginService.getMembers();

//        model.addAttribute("members", members);

        return "index/contextPost";
    }
    @PostMapping(value = "/registerPost")
    public String registerPost(@RequestParam("boardTitle") String boardTitle,
                               @RequestParam("boardContext") String boardContext,
                               HttpSession session,
                               Model model) {

        int boardNo = (int) session.getAttribute("size");
        Member member = (Member) session.getAttribute("member");
        postService.registerPost(boardNo, null, member.getMemNo(),
            1, String.valueOf(boardNo), boardTitle, boardContext,
            new Date(), null, 0, 0, false);

        return "index/postPage";
    }



    @GetMapping(value = "/listPost")
    public String listPostForm(Model model) {
        List<Post> posts = postService.getPosts();
        model.addAttribute("posts", posts);
        return "index/listPost";
    }

    @GetMapping("/removePost/{boardNo}")
    public String removePostForm(@PathVariable int boardNo) {
        postService.deletePost(boardNo);
        return "index/postPage";
    }

    @GetMapping("/registerPost")
    public String registerPostForm(Model model, HttpSession session) {

        List<Post> posts = postService.getPosts();
        int size = posts.size()+1;
        session.setAttribute("size", size);
        Member member = (Member) session.getAttribute("member");
        model.addAttribute("size", size);
        model.addAttribute("member", member);

        return  "index/registerPost";
    }

    @GetMapping(value = "/postPage")
    public String postPage() {
        return "index/postPage";
    }

}
