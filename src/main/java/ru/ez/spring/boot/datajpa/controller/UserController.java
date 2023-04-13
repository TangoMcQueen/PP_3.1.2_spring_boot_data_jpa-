package ru.ez.spring.boot.datajpa.controller;

import ru.ez.spring.boot.datajpa.model.User;
import ru.ez.spring.boot.datajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(ModelMap model) {
        model.addAttribute("users", userService.listAllUsers());
        return "users";
    }
    @GetMapping("/users/new")
    public String addNewUser(Model model) {
        model.addAttribute("user",new User());
        return "user_info";
    }
    @PostMapping("/userAdd")
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_info";
        }
        userService.saveOrUpdateUser(user);
        return "redirect:/";
    }
    @GetMapping("/users/{id}")
    public String getUser(Model model, @PathVariable("id") int id) {
        User user = userService.getUser(id);
        if (user == null) {
            model.addAttribute("user",new User());
            return "user_info";
        }
        model.addAttribute("user", userService.getUser(id));
        return "updateUser";
    }
    @PutMapping("/users/{id}")
    public String update (@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateUser";
        }
        userService.saveOrUpdateUser(user);
        return "redirect:/";
    }
    @DeleteMapping("/users/{id}")
    public String delete (@PathVariable("id") int id) {
        User user = userService.getUser(id);
        if (user == null) {
            return "user_info";
        }
        userService.deleteUser(id);
        return "redirect:/";
    }
}