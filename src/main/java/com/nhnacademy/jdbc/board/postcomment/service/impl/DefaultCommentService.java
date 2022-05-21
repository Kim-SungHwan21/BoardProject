package com.nhnacademy.jdbc.board.postcomment.service.impl;

import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.postcomment.mapper.CommentMapper;
import com.nhnacademy.jdbc.board.postcomment.service.CommentService;
import java.util.Date;
import java.util.List;

public class DefaultCommentService implements CommentService {
    private final CommentMapper commentMapper;

    public DefaultCommentService(
        CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<Post> getComments() {
        return commentMapper.selectComments();
    }

    @Override
    public void registerComment(int postCommentNo, int parentsCommentNo, int memNo, int boardNo,
                                int postCommentDepth, String postCommentLevelNo,
                                String postCommentContext, Date postCommentRegisterDatetime) {
        commentMapper.registerComment(postCommentNo, parentsCommentNo, memNo, boardNo, postCommentDepth, postCommentLevelNo,
             postCommentContext, postCommentRegisterDatetime);
    }

    @Override
    public void modifyComment(int postCommentNo, String postCommentContext) {
        commentMapper.updateContextByNo(postCommentNo, postCommentContext);
    }

    @Override
    public void deleteComment(int postCommentNo) {
        commentMapper.deleteByNo(postCommentNo);
    }
}
