package com.nhnacademy.jdbc.board.post.mapper;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.post.domain.Post;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

public interface PostMapper {
    Optional<Post> selectPost(@Param("boardNo") int boardNo);
    List<Post> selectPosts();
    void registerPost(Post post);
    void updateContextByNo(@Param("boardContext") String boardContext,@Param("boardTitle") String boardTitle,@Param("boardNo") int boardNo);
    void deleteByNo(@Param("boardNo") int boardNo);
    Optional<Member> selectPostWriter(@Param("boardNo") int boardNo);
}
