package com.nhnacademy.jdbc.board.postlike.domain;

import lombok.Getter;

@Getter
public class PostLike {
    private int memNo;
    private int boardNo;
    private int postLikeCount;

    public PostLike(int memNo, int boardNo, int postLikeCount) {
        this.memNo = memNo;
        this.boardNo = boardNo;
        this.postLikeCount = postLikeCount;
    }

    @Override
    public String toString() {
        return "PostLike{" +
            "memNo=" + memNo +
            ", boardNo=" + boardNo +
            ", postLikeCount=" + postLikeCount +
            '}';
    }
}
