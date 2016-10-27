package com.study.service;

import com.study.domain.Member;
import com.study.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yongjunjung on 2016. 10. 27..
 */

@Service
public class MemberService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MemberRepository memberRepository;

    public void join(Member member) {

        validationDuplicateMember(member);
        memberRepository.save(member);
    }

    private void validationDuplicateMember(Member member) {

        List<Member> findMembers = memberRepository.findByName(member.getName());

        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> list() {
        return memberRepository.findAll();
    }

}
