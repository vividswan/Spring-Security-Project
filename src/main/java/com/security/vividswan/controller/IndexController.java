package com.security.vividswan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/join")
    public @ResponseBody String join(){
        return "join";
    }

    @GetMapping("/joinProc")
    public @ResponseBody String joinProc(){
        return "join success";
    }
    @GetMapping("/login")
    public @ResponseBody String login(){
        return "login";
    }
}
