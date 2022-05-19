package com.nhnacademy.jdbc.board.member.service;

import com.nhnacademy.jdbc.board.member.domain.Member;
import java.util.Optional;

public interface MemberLoginService {
    Optional<Member> getMember(int id);
    boolean matches(String memId, String password)
}
