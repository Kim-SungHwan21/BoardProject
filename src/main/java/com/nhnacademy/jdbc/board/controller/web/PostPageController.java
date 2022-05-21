package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.member.service.MemberLoginService;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.service.PostService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
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

    public PostPageController(PostService postService) {
        this.postService = postService;
    }


//    @GetMapping(value = {"/contextPost"})
//    public String contextPost(HttpServletRequest request,
//                              @RequestParam("boardNo") int boardNo,
//                              @RequestParam("memId") String memId) {
//        Optional<Post> post = postService.getPost(boardNo);
//        request.setAttribute("post", post.get());
//        Optional<Member> member = memberLoginService.getMember(memId);
//        request.setAttribute("member", member.get());

//        return "index/contextPost";
//    }
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
//        List<Member> members = memberLoginService.getMembers();

//        model.addAttribute("members", members);

        return "index/contextPost";
    }
//    @PostMapping(value = "/registerPost")
//    public String registerPost(Post post,
//                               @RequestParam("boardNo") int boardNo,
//                               @RequestParam("parentsBoardNo") int parentsBoardNo,
//                               @RequestParam("memNo") int memNo,
//                               @RequestParam("boardDepth") int boardDepth,
//                               @RequestParam("boardLevelNo") String boardLevelNo,
//                               @RequestParam("boardTitle") String boardTitle,
//                               @RequestParam("boardContext") String boardContext,
//                               @RequestParam("boardRegisterDateTime") Date boardRegisterDateTime,
//                               @RequestParam("boardModifyDateTime") Date boardModifyDateTime,
//                               @RequestParam("boardCommentCount") int boardCommentCount,
//                               @RequestParam("boardViewCount") int boardViewCount,
//                               @RequestParam("boardDeleteCheck") boolean boardDeleteCheck,
//                               @RequestParam("memId") String memId) {
//
//        Post post = new Post(boardNo, parentsBoardNo, memNo, boardDepth, boardLevelNo, boardTitle,
//            boardContext, boardRegisterDateTime, boardModifyDateTime, boardCommentCount,
//            boardViewCount, boardDeleteCheck, memId);
//
//        postService.registerPost(post);

//        return "index/registerPost";

//    }



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
    public String registerPostForm() {
        return  "index/registerPost";
    }

    @GetMapping(value = "/postPage")
    public String postPage() {
        return "index/postPage";
    }
}
