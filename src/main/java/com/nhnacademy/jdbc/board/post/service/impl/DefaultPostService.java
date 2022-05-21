package com.nhnacademy.jdbc.board.post.service.impl;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.mapper.PostMapper;
import com.nhnacademy.jdbc.board.post.service.PostService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DefaultPostService implements PostService {
    private final PostMapper postMapper;


    public DefaultPostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }


    @Override
    public List<Post> getPosts() {
        return postMapper.selectPosts();
    }

    @Override
    public Optional<Post> getPost(int boardNo) {
        return postMapper.selectPost(boardNo);
    }

    @Override
    public void registerPost(Post post) {
        postMapper.registerPost(post);
    }

    @Override
    public void modifyPost(int boardNo, String title, String content) {
        postMapper.updateContextByNo(content, title, boardNo);
    }

    @Override
    public void deletePost(int boardNo) {
        postMapper.deleteByNo(boardNo);
    }

    @Override
    public Optional<Member> getPostWriter(int boardNo) {
        return postMapper.selectPostWriter(boardNo);
    }

}