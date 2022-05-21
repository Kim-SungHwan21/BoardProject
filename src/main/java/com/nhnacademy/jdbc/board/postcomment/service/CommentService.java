package com.nhnacademy.jdbc.board.postcomment.service;

import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.postcomment.domain.PostComment;
import java.util.Date;
import java.util.List;

public interface CommentService {
    List<PostComment> getComments(int boardNo);
    void registerComment(int postCommentNo, int parentsCommentNo, int memNo, int boardNo,
                         int postCommentDepth, String postCommentLevelNo,
                         String postCommentContext, Date postCommentRegisterDatetime);
    void modifyComment(int postCommentNo, String postCommentContext);
    void deleteComment(int postCommentNo);
}
