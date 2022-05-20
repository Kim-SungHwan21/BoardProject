package com.nhnacademy.jdbc.board.member.domain;

import lombok.Data;


@Data
public class Member {
    private int memNo;
    private String memId;
    private String memPassword;

//    public Member(int memNo, String memId, String memPassword) {
//        this.memNo = memNo;
//        this.memId = memId;
//        this.memPassword = memPassword;
//    }

    @Override
    public String toString() {
        return "Mem{" +
            "memNo=" + memNo +
            ", memId='" + memId + '\'' +
            ", memPassword='" + memPassword + '\'' +
            '}';
    }

}
