package io.gffd94.grepp_spring_mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Slf4j
@Controller
public class FourthController {

    @GetMapping("/path1/{name}")
    public String showPage1(@PathVariable(name = "name") String name) {

        log.info("name = {}", name);

        return "index";
    }

    // 구체적인 세부적인 것이 우선!
    @GetMapping("/path1/admin")
    public String showPage2() {

        log.info("admin");

        return "index";
    }

    // 하나의 메서드에 2개이상의  url을 걸때! -> required = false
    @GetMapping({"/path2/{name}", "/path2"})        // false 면 null 들어감 // Optional을 걸어서 null을 막음
    public String showPage3(@PathVariable(name = "name", required = false) Optional<String> name) {

        log.info("name = {}", name);

        return "index";
    }

    // 2개 이상도 가능
    @GetMapping("/boards/{boardName}/posts/{postId}")
    public String showPage4(
            @PathVariable String boardName,
            @PathVariable Integer postId
    ){

        log.info("boardName = {}", boardName);
        log.info("postId = {}", postId);
        
        return "index";
    }

}
