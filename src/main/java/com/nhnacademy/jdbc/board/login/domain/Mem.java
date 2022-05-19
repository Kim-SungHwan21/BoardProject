package com.nhnacademy.jdbc.board.login.domain;

import lombok.Getter;

@Getter
public class Mem {
    private int memNo;
    private String memId;
    private String memPassword;

    public Mem(int memNo, String memId, String memPassword) {
        this.memNo = memNo;
        this.memId = memId;
        this.memPassword = memPassword;
    }

    @Override
    public String toString() {
        return "Mem{" +
            "memNo=" + memNo +
            ", memId='" + memId + '\'' +
            ", memPassword='" + memPassword + '\'' +
            '}';
    }
}
