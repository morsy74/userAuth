package com.example.mvcdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  
  @GetMapping("/")
  public String home() {
    return "index";
  }

  @GetMapping("/general")
  public String general() {
    return "user/general";
  }
}
