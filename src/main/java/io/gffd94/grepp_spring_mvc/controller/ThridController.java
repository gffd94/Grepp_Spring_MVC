package io.gffd94.grepp_spring_mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Controller
public class ThridController {

    @GetMapping("/params1")
    public String showParams1(HttpServletRequest request) {

        String name = request.getParameter("name");
        log.info("name = {}", name);

        Map<String, String[]> parameterMap = request.getParameterMap();


//        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
//        for (Map.Entry<String, String[]> entry : entries) {
//            log.info("{} = {}", entry.getKey(), Arrays.toString(entry.getValue()));
//        }

        parameterMap.forEach((key, value) -> log.info("key = {}, value = {}", key, value));

        log.info("parameterMap = {}", parameterMap);

        return "index";
    }

    @GetMapping("/params2")
    public String showParams2(@RequestParam(name = "name") String name) {

        log.info("name = {}", name);

        return "index";
    }

    @GetMapping("/params3")
    public String showParams3(
            @RequestParam(name = "name" , required = false) String name,
            @RequestParam(name = "age" , required = false, defaultValue = "1") Integer age) {

        log.info("name = {}", name);
        log.info("age = {}", age);

        return "index";
    }

    @GetMapping("/params4")
    public String showParams4(String name){

        log.info("name = {}", name);

        return "index";
    }


    // id paswward
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
//    @Data 위에 있는거 다 들어있음
    class SignInRequest {
        private String username;
        private String password;

    }

    @GetMapping("/params5")
    public String showParams5(SignInRequest singInRequest) {

        log.info("singInRequest= {}", singInRequest);

        log.info("singInRequest.username = {}", singInRequest.username);
        log.info("singInRequest.password = {}", singInRequest.password);

        return "index";
    }


    @GetMapping("/params6")
    // ModelAttribute는 생략각능
    public String showParams6(@ModelAttribute SignInRequest singInRequest) {

        log.info("singInRequest.username = {}", singInRequest.username);
        log.info("singInRequest.password = {}", singInRequest.password);

        return "index";
    }

    @GetMapping("/params7")
    // 여러개 받으려면 list 말고 String[]로 받아야함
    public String showParams7(String[] favorites)  {

        for (String favorite : favorites) {
            log.info("favorite = {}", favorite);
        }

        return "index";
    }



}
