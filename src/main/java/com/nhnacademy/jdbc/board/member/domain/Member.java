package com.nhnacademy.jdbc.board.member.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Member {
    private int memNo;
    private String memId;
    private String memPassword;

    public Member(int memNo, String memId) {
        this.memNo = memNo;
        this.memId = memId;
    }
}
