package com.security.vividswan.controller;

import com.security.vividswan.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // return view
public class IndexController {
    @GetMapping({"","/"})
    public String index(){
        // mustache : src/main/resources/
        // viewResolver : templates (prefix), .mustache (suffix)
        return "index";
    }

    @GetMapping("/user")
    public @ResponseBody String user(){
        return "user";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager(){
        return "manager";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }

    @GetMapping("/joinProc")
    public @ResponseBody String joinProc(){
        return "join success";
    }

    @GetMapping("/joinForm")
    public String join(){
        return "joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @PostMapping("/join")
    public @ResponseBody String join(User user){
        System.out.println();
        return "join";
    }
}
