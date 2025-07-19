package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "login", method=RequestMethod.GET)
    public String goToLoginPage() {
        return "login";
    }

    @RequestMapping(value = "login", method=RequestMethod.POST)
    public String requestMethodName(@RequestParam String name, @RequestParam String password, ModelMap model) {
        if(authenticationService.isValidUser(name, password)) {
            model.put("name", name);
            return "welcome";
        }
        else {
            model.put("errorMessage", "Invalid Credentials! Please try again.");
            return "login";
        }
    }
    

    // Logger logger = LoggerFactory.getLogger(getClass());



    //Model => using value in request param in login.jsp
    // @RequestMapping("login")
    // public String loginPage(@RequestParam String name, ModelMap model) {
    //     // logger.debug("Request param is {}", name); // it will only printed when at debug level it is more recommended then Sysout
    //     // logger.info("Request param at info level is {} ", name);
    //     // System.out.println("Name in request param is " + name);
    //     model.put("name", name);
    //     return "login";
    // }
}
