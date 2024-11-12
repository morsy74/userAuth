package com.example.mvcdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvcdemo.database.entity.User;
import com.example.mvcdemo.service.UserService;

@Controller
public class UserController {
   private final UserService userService;

   public UserController(UserService userService) {
      this.userService = userService;
   }

  @GetMapping("/login")
  public String login() {
    return "user/login";
  }

  @PostMapping("/login")
  public String loginPost(
      @RequestParam("username") String username,
      @RequestParam("password") String password) {
      
    return "/general";
  }
  

  @GetMapping("/signup")
  public String signup() {
    return "user/signup";
  }

  @PostMapping("/signup")
  public String signupPost(
    @RequestParam("username") String username,
    @RequestParam("password") String password) {
      User user = new User();
      user.setUsername(username);
      user.setPassword(password);
      userService.addUser(user);
    return "/general";
  }
}
