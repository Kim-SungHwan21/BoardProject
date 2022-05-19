package com.nhnacademy.jdbc.board.member.mapper;

import com.nhnacademy.jdbc.board.member.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberMapper {
    Optional<Member> selectMember(long id);
    List<Member> selectMembers();
    void insertMember(Member member);
    void updatePasswordById(String name, long id);
    void deleteById(long id);
}
