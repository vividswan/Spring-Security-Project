package com.security.vividswan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // return view
public class IndexController {
    @GetMapping({"","/"})
    public String index(){
        return "index";
    }
}
