package com.nhnacademy.jdbc.board.post.service;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.post.domain.Post;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getPosts();
    Optional<Post> getPost(int boardNo);
    void registerPost(int boardNo, int parentsBoardNo, int memNo, int boardDepth,
                      String boardLevelNo, String boardTitle, String boardContext,
                      Date boardRegisterDatetime, Date boardModifyDatetime, int boardCommentCount,
                      int boardViewCount, boolean boardDeleteCheck);
    void modifyPost(int boardNo, String title, String content);
    void deletePost(int boardNo);
    Optional<Member> getPostWriter(int boardNo);
}
