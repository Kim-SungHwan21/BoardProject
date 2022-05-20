package com.nhnacademy.jdbc.board.member.service.impl;

import com.nhnacademy.jdbc.board.member.domain.Member;
import com.nhnacademy.jdbc.board.member.mapper.MemberMapper;
import com.nhnacademy.jdbc.board.member.service.MemberLoginService;
import com.nhnacademy.jdbc.board.post.domain.Post;
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
    public Optional<Member> getMember(String memId) {
        return memberMapper.selectMember(memId);
    }

    @Override
    public boolean isLogin(String memId, String password) {
        Optional<Member> member = memberMapper.selectMember(memId);
        System.out.println("member : "+ member);

        if (member.get().getMemId().equals(memId) && member.get().getMemPassword().equals(password)) {
            return true;
        }
        else {
            return false;
        }
    }

}
