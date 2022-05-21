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
    private String memId;

}
