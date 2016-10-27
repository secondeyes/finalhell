package com.study.api;

import com.study.domain.Address;
import com.study.domain.Member;
import com.study.repository.MemberRepository;
import com.study.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by yongjunjung on 2016. 10. 26..
 */

@Controller
public class MemberController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/members/new", method = GET)
    public String joinMember() {
        return "member/join";

    }

    @RequestMapping(value = "/members/new", method = POST)
    public String newMember(@RequestParam Map<String, String> map) {

        //todo Map 쓰면 안되는데.. 에헴;;;

        Member member = new Member();
        member.setName(map.get("name"));

        Address address = new Address(map.get("city"), map.get("street"), map.get("zipcode"));
        member.setAddress(address);

        memberService.join(member);

        return "redirect:/";
    }

    @RequestMapping(value = "/members", method = GET)
    public String memberList(Model model) {

        List<Member> list = memberService.list();
        model.addAttribute("members", list);

        return "member/list";
    }

}
