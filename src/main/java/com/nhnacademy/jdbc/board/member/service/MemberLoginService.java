package com.nhnacademy.jdbc.board.member.service;

import com.nhnacademy.jdbc.board.member.domain.Member;
import java.util.Optional;

public interface MemberLoginService {
    boolean isLogin(String id, String password);
}
