package com.Signup.authWithBcrypt.controller;
import com.Signup.authWithBcrypt.models.PostUser;
import com.Signup.authWithBcrypt.models.SiteUser;
import com.Signup.authWithBcrypt.repositories.PostRepository;
import com.Signup.authWithBcrypt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AuthPost {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;
    @GetMapping("/post")
    public String getHomePage(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("username") != null){
            List<PostUser> posts = postRepository.findAll();
            model.addAttribute("posts", posts);
            String username = (String) request.getSession().getAttribute("username");
            model.addAttribute("username", username);
            return "loginpost";
        }
        return "redirect:/login";
    }
    @PostMapping("/posts")
    public RedirectView savePost(HttpServletRequest request, String textContent){
        String username = (String) request.getSession().getAttribute("username");
        SiteUser user = userRepository.findByUsername(username);
        PostUser post = new PostUser(textContent, user);
        postRepository.save(post);
        return new RedirectView("/post");
    }

}

