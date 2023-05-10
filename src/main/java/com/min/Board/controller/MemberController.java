package com.min.Board.controller;

import com.min.Board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //Autowired 어노테이션을 통해 Service와 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
