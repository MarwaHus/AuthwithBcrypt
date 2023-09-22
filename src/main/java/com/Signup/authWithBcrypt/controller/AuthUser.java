package com.Signup.authWithBcrypt.controller;

import com.Signup.authWithBcrypt.models.SiteUser;
import com.Signup.authWithBcrypt.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthUser {
    @Autowired
    UserRepository userRepository;


    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }
    @GetMapping("/login")
    public String getLogin(){
        return "/login";
    }

    @GetMapping("/signup")
    public String getSignup(){
        return "/signup";
    }
    @PostMapping("/signup")
    public RedirectView signUpBcrypt(String username ,String password){
        String signUpHashPassword = BCrypt.hashpw(password,BCrypt.gensalt(10));
        SiteUser siteUser =new SiteUser(username,signUpHashPassword);
        userRepository.save(siteUser);
        return new RedirectView ("login");
    }

   @PostMapping("/login")
   public RedirectView login(HttpServletRequest request, String username ,String password) {
       SiteUser userDataBase = userRepository.findByUsername(username);
       if((userDataBase == null) || (!BCrypt.checkpw(password, userDataBase.getPassword())))
       {
           return new RedirectView("/login");
       }
       HttpSession session= request.getSession();
       session.setAttribute("username", username);
       return new RedirectView("/post");

   }

}
