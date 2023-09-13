package com.Signup.authWithBcrypt.controller;
import com.Signup.authWithBcrypt.models.SiteUser;
import com.Signup.authWithBcrypt.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthPost {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/post")
    public RedirectView logInUSerWithSecret(HttpServletRequest request, String username, String password){
        SiteUser userDataBase=userRepository.findByUsername(username);

        if((userDataBase == null)
                || (!BCrypt.checkpw(password, userDataBase.getPassword())))
        {

            return new RedirectView("/post");
        }
        HttpSession session= request.getSession();
        session.setAttribute("username", username);

        return new RedirectView("/login");
    }


}

