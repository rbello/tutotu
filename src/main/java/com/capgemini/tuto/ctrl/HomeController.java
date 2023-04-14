package com.capgemini.tuto.ctrl;

import com.capgemini.tuto.dto.CreateRequest;
import com.capgemini.tuto.dto.TaskResponse;
import com.capgemini.tuto.srv.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }

    @PostMapping("/")
    public void create(@RequestBody CreateRequest request) {
        // Bind to service layer...
    }

    @GetMapping("/task/")
    public List<TaskResponse> getTasks() {
        return taskService.getTasks();
    }

}
