package com.nhnacademy.jdbc.board.postcomment.mapper;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.post.domain.Post;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    void registerComment(@Param("postCommentNo") int postCommentNo, @Param("parentsCommentNo") int parentsCommentNo,
                         @Param("memNo") int memNo, @Param("boardNo") int boardNo,
                         @Param("postCommentDepth") int postCommentDepth, @Param("postCommentLevelNo") String postCommentLevelNo,
                         @Param("postCommentContext") String postCommentContext, @Param("postCommentRegisterDatetime") Date postCommentRegisterDatetime);

    void updateContextByNo(@Param("postCommentNo") int postCommentNo, @Param("postCommentContext") String postCommentContext);

    void deleteByNo(int postCommentNo);

    List<Post> selectComments();

    Optional<Member> selectCommentWriter(@Param("postCommentNo") int postCommentNo);
}
