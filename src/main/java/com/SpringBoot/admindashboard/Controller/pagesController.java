package com.SpringBoot.admindashboard.Controller;

import com.SpringBoot.admindashboard.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class pagesController {
    @Autowired
    private StaffService staffService;
    @GetMapping("/login")
    public String renderLoginPage()
    {
        return ("loginPage");
    }
    @GetMapping("/home")
    public String staffHomePage()
    {
        return ("adminHome");
    }
    @GetMapping("/admin")
    public String adminHomePage()
    {
        return ("redirect:/home?admin=true");
    }
    @GetMapping("/setPassword/{id}")
    public String staffSetPassword(@RequestAttribute Long id)
    {
        return ("setPassword");
    }

}
