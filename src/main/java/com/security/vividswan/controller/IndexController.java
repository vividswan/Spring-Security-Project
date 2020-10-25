package com.security.vividswan.controller;

import com.security.vividswan.auth.PrincipalDetails;
import com.security.vividswan.dto.UserInfoDto;
import com.security.vividswan.model.User;
import com.security.vividswan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // return view
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping({"","/"})
    public String index(){
        return "index";
    }

    @GetMapping("/user")
    public @ResponseBody UserInfoDto user(@AuthenticationPrincipal PrincipalDetails principalDetails){
        UserInfoDto userInfoDto = UserInfoDto.builder()
                .id(principalDetails.getUser().getId())
                .email(principalDetails.getUser().getEmail())
                .role(principalDetails.getUser().getRole())
                .providerId(principalDetails.getUser().getProviderId())
                .createDate(principalDetails.getUser().getCreateDate())
                .build();
        return userInfoDto;
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
    public String join(User user){
        user.setRole("ROLE_USER");
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        userRepository.save(user);
        return "redirect:/loginForm";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/privateInfo")
    public @ResponseBody String privateInfo(){
        return "privateInfo";
    }

    @PreAuthorize("hasROLE('ROLE_ADMIN') or hasROLE('ROLE_MANAGER')")
    @GetMapping("/date")
    public @ResponseBody String data(){
        return "data";
    }
}
