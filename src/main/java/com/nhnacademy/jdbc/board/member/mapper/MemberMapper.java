package com.nhnacademy.jdbc.board.member.mapper;

import com.nhnacademy.jdbc.board.member.domain.Member;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Optional<Member> selectMember(String id);
    List<Member> selectMembers();
    void insertMember(Member member);
}
