package com.capgemini.tuto.ctrl;

import com.capgemini.tuto.dto.CreateRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }

    @PostMapping("/")
    public void create(@RequestBody CreateRequest request) {
        // Bind to service layer...
    }

}
