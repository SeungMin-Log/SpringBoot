package com.min.Board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/* 김영한 강사님 섹션2정리 */
@Controller
public class BoardController {

    /* 모델을 활용한 MVC 예제 */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hellomvc";
    }

    /* 문자열을 활용한 MVC예제 */
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    /* 별도의 API(Hello클래스)를 활용한 MVC 예제 */
    @GetMapping("hello-api")
    @ResponseBody /* Spring에서 HttpMessageConverter가 Jackson을 사용해서 Json타입으로 변환하여 HTML로 전달 */
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        /* 프로퍼티 접근 방식 */ 
        /* 자바 빈 표준방식 게터 세터 */
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
