package com.nhnacademy.jdbc.board.member.service;

import com.nhnacademy.jdbc.board.member.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberLoginService {
    Optional<Member> doLogin(String id, String password);
    Optional<Member> getMember(String memId);
    List<Member> getMembers();
}
