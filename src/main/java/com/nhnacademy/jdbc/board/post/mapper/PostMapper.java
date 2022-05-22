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
    List<Post> selectPostsOrderByBoardNo(@Param("page") int page);
    void registerPost(@Param("boardNo") int boardNo, @Param("parentsBoardNo") Integer parentsBoardNo, @Param("memNo") int memNo, @Param("boardDepth") int boardDepth,
                      @Param("boardLevelNo") String boardLevelNo,@Param("boardTitle") String boardTitle, @Param("boardContext") String boardContext,
                      @Param("boardRegisterDatetime") Date boardRegisterDatetime, @Param("boardModifyDatetime") Date boardModifyDatetime, @Param("boardCommentCount") Integer boardCommentCount,
                      @Param("boardViewCount") Integer boardViewCount, @Param("boardDeleteCheck") boolean boardDeleteCheck);
    void updateContextByNo(@Param("boardContext") String boardContext,@Param("boardTitle") String boardTitle,@Param("boardNo") int boardNo);
    void deleteByNo(int boardNo);
    Optional<Member> selectPostWriter(@Param("boardNo") int boardNo);
}
