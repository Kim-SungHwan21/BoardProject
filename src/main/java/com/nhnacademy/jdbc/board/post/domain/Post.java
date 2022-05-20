package com.nhnacademy.jdbc.board.post.domain;

import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString
public class Post {
    private int boardNo;
    private int parentsBoardNo;
    private int memNo;
    private int boardDepth;
    private String boardLevelNo;
    private String boardTitle;
    private String boardContext;
    private Date boardRegisterDatetime;
    private Date boardModifyDatetime;
    private int boardCommentCount;
    private int boardViewCount;
    private boolean boardDeleteCheck;

//    public Post(int boardNo,
//                int parentsBoardNo,
//                int memNo,
//                int boardDepth,
//                String boardLevelNo, String boardTitle, String boardContext,
//                Timestamp boardRegisterDatetime, Timestamp boardModifyDatetime, int boardCommentCount,
//                int boardViewCount, boolean boardDeleteCheck) {
//        this.boardNo = boardNo;
//        this.parentsBoardNo = parentsBoardNo;
//        this.memNo = memNo;
//        this.boardDepth = boardDepth;
//        this.boardLevelNo = boardLevelNo;
//        this.boardTitle = boardTitle;
//        this.boardContext = boardContext;
//        this.boardRegisterDatetime = boardRegisterDatetime;
//        this.boardModifyDatetime = boardModifyDatetime;
//        this.boardCommentCount = boardCommentCount;
//        this.boardViewCount = boardViewCount;
//        this.boardDeleteCheck = boardDeleteCheck;
//    }

//    @Override
//    public String toString() {
//        return "Post{" +
//            "boardNo=" + boardNo +
//            ", parentsBoardNo=" + parentsBoardNo +
//            ", memNo=" + memNo +
//            ", boardDepth=" + boardDepth +
//            ", boardLevelNo='" + boardLevelNo + '\'' +
//            ", boardTitle='" + boardTitle + '\'' +
//            ", boardContext='" + boardContext + '\'' +
//            ", boardRegisterDatetime=" + boardRegisterDatetime +
//            ", boardModifyDatetime=" + boardModifyDatetime +
//            ", boardCommentCount=" + boardCommentCount +
//            ", boardViewCount=" + boardViewCount +
//            ", boardDeleteCheck=" + boardDeleteCheck +
//            '}';
//    }
        }
