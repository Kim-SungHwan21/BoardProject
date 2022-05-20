package com.nhnacademy.jdbc.board.post.mapper;

import com.nhnacademy.jdbc.board.post.domain.Post;
import java.util.List;
import java.util.Optional;

public interface PostMapper {
    Optional<Post> selectPost(int BoardNo);
    List<Post> selectPosts();
    void registerPost(Post post);
    void updateContextByNo(String boardContext, String boardTitle, int boardNo);
    void deleteByNo(int boardNo);
}
