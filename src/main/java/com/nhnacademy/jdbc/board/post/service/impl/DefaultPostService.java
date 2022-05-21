package com.nhnacademy.jdbc.board.post.service.impl;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.mapper.PostMapper;
import com.nhnacademy.jdbc.board.post.service.PostService;
import java.util.Date;
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
    public void registerPost(int boardNo, int parentsBoardNo, int memNo, int boardDepth,
                             String boardLevelNo, String boardTitle, String boardContext,
                             Date boardRegisterDatetime, Date boardModifyDatetime, int boardCommentCount,
                             int boardViewCount, boolean boardDeleteCheck) {

        List<Post> posts = getPosts();
        Date now = new Date();
        String boardLevel = String.valueOf(posts.size()+1);

        postMapper.registerPost(posts.size()+1, 0, 1, 1,
            boardLevel, boardTitle, boardContext,
            now, null, 0,
            0, false);
    }

    @Override
    public void modifyPost(int boardNo, String title, String content) {
        System.out.println(content);
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