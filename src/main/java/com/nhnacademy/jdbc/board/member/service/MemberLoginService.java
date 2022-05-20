package com.nhnacademy.jdbc.board.member.service;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.post.domain.Post;
import java.util.List;
import java.util.Optional;

public interface MemberLoginService {
    boolean isLogin(String id, String password);
    Optional<Member> getMember(String memId);
    List<Member> getMembers();
}
