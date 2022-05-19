package com.nhnacademy.jdbc.board.postcomment.domain;

import java.util.Date;
import lombok.Getter;

@Getter
public class postComment {
    private int postCommentNo;
    private int parentsCommentNo;
    private int memNo;
    private int boardNo;
    private int postCommentDepth;
    private String postCommentLevelNo;
    private String postCommentContext;
    private Date postCommentRegisterDatetime;

    public postComment(int postCommentNo, int parentsCommentNo, int memNo, int boardNo,
                       int postCommentDepth, String postCommentLevelNo,
                       String postCommentContext, Date postCommentRegisterDatetime) {
        this.postCommentNo = postCommentNo;
        this.parentsCommentNo = parentsCommentNo;
        this.memNo = memNo;
        this.boardNo = boardNo;
        this.postCommentDepth = postCommentDepth;
        this.postCommentLevelNo = postCommentLevelNo;
        this.postCommentContext = postCommentContext;
        this.postCommentRegisterDatetime = postCommentRegisterDatetime;
    }

    @Override
    public String toString() {
        return "postComment{" +
            "postCommentNo=" + postCommentNo +
            ", parentsCommentNo=" + parentsCommentNo +
            ", memNo=" + memNo +
            ", boardNo=" + boardNo +
            ", postCommentDepth=" + postCommentDepth +
            ", postCommentLevelNo='" + postCommentLevelNo + '\'' +
            ", postCommentContext='" + postCommentContext + '\'' +
            ", postCommentRegisterDatetime=" + postCommentRegisterDatetime +
            '}';
    }
}
