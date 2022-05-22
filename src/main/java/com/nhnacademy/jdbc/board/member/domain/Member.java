package com.nhnacademy.jdbc.board.member.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;


@Data
@ToString
public class Member {
    private int memNo;
    private String memId;
    private String memPassword;
}
