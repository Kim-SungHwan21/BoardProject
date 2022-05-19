package com.nhnacademy.jdbc.board.member.service.impl;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.member.mapper.MemberMapper;
import com.nhnacademy.jdbc.board.member.service.MemberLoginService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DefaultMemberLoginService implements MemberLoginService {
    private final MemberMapper memberMapper;

    public DefaultMemberLoginService(
        MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


    @Override
    public Optional<Member> getMember(int id) {
        return memberMapper.selectMember(id);
    }
}
