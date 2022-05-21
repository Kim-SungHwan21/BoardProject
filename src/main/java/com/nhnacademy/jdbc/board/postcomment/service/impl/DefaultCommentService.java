package com.nhnacademy.jdbc.board.postcomment.service.impl;

import com.nhnacademy.jdbc.board.postcomment.domain.PostComment;
import com.nhnacademy.jdbc.board.postcomment.mapper.CommentMapper;
import com.nhnacademy.jdbc.board.postcomment.service.CommentService;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DefaultCommentService implements CommentService {
    private final CommentMapper commentMapper;

    public DefaultCommentService(
        CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<PostComment> getComments(int boardNo) {
        return commentMapper.selectComments(boardNo);
    }

    @Override
    public void registerComment(int postCommentNo, Integer parentsCommentNo, int memNo, int boardNo,
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

    @Override
    public List<PostComment> getAllComments() {
        return commentMapper.selectAllComments();
    }
}
