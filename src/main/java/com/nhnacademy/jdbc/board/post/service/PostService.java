package com.nhnacademy.jdbc.board.post.service;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.post.domain.Post;
import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getPosts();
    Optional<Post> getPost(int boardNo);
    void registerPost(Post post);
    void modifyPost(int boardNo, Post post);
    void deletePost(int boardNo);
    Optional<Member> getPostWriter(int boardNo);
}
