package io.gffd94.grepp_spring_mvc.controller;


import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;

@Slf4j
@Controller
public class FirstController {

    // http://localhost:8080/hello-world
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public void receiveRequestFromBrowser(){
      log.info("Hello World");
    }

    @GetMapping("/print-spring")
    public void printSpring1(HttpServletResponse response) throws Exception {
        log.info("안녕하세요!");
        // 응답 본문에 내용을 보여줌
        PrintWriter writer = response.getWriter();
        writer.println("Hello World!!");
    }

    @GetMapping("/print-spring2")
    public void printSpring2(HttpServletResponse response) throws Exception {
        log.info("안녕하세요!");
        // UTF-8로 인코딩해줌 , 순서도 중요=> 인코딩한 것을 printwriter로 꺼내서 보여주기 때문
        response.setContentType("text/html;charset=UTF-8");

        // 응답 본문에 내용을 보여줌
        PrintWriter writer = response.getWriter();
        writer.println("안녕 세상아!!!");
    }

    @ResponseBody
    // 여기 url 을 endpoint로 불림
    @GetMapping("/print-spring3")
    public String printSpring3() {
        return "안녕하세요! 반가워요!";

    }

    @ResponseBody
    @GetMapping("/print-integer")
    public Integer printInteger() {
        return 1;
    }

    @Getter
    class SomeType{
        private final String data = "데이터!";

    }

    @ResponseBody
    @GetMapping("/print-obj")
    public SomeType printObject(){
        return new SomeType();
    }


    @ResponseBody
    @GetMapping("/print-string-2")
    public String printSomething() {
        return "<html>" +
                "<head>" +
                "<title>" +
                "안녕하세요!" +
                "</title>" +
                "</head>" +
                "<body>" +
                "<h1>" +
                "Hello!!" +
                "</h1>" +
                "</body>" +
                "</html>";

    }

    // 직렬화
    // jackson library : 자바에 있는 객체를 JSON형태로 바꿈
    
}
