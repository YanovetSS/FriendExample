package ukraine.example.controller;

import com.sun.deploy.net.HttpResponse;
import javafx.scene.media.AudioClip;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap modelMap) {
        modelMap.addAttribute("welcomeMessage", "Spring MVC HELLO");
        return "index";
    }

    @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
    public String adminPage(ModelMap modelMap) {
        modelMap.addAttribute("user", getPrincipal());
        return "adminPage";
    }

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String userPage(ModelMap modelMap) {
        modelMap.addAttribute("user", getPrincipal());
        return "userPage";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "index";
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String accessDenied(ModelMap modelMap){
        modelMap.addAttribute("user",getPrincipal());
        return "accessDenied";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
