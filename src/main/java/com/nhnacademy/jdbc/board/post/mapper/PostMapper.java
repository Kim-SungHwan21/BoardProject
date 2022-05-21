package com.nhnacademy.jdbc.board.post.mapper;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.post.domain.Post;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

public interface PostMapper {
    Optional<Post> selectPost(@Param("boardNo") int boardNo);
    List<Post> selectPosts();
    void registerPost(int boardNo, int parentsBoardNo, int memNo, int boardDepth,
                      String boardLevelNo, String boardTitle, String boardContext,
                      Date boardRegisterDatetime, Date boardModifyDatetime, int boardCommentCount,
                      int boardViewCount, boolean boardDeleteCheck);
    void updateContextByNo(@Param("boardContext") String boardContext,@Param("boardTitle") String boardTitle,@Param("boardNo") int boardNo);
    void deleteByNo(int boardNo);
    Optional<Member> selectPostWriter(@Param("boardNo") int boardNo);
}
