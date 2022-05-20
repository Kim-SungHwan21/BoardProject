package com.nhnacademy.jdbc.board.member.domain;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class Member {
    private int memNo;
    private String memId;
    private String memPassword;
}
