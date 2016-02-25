package com.kriloleg.inv.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping
    public String adminHomePage() {
        return "admin";
    }

}
