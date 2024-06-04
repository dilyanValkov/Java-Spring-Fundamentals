package com.softuni.Pathfinder.web.controller;

import com.softuni.Pathfinder.web.dto.UserRegisterDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@RequestMapping("/users")
@Controller
public class UserController {

    @GetMapping("/register")
    private String viewRegister(Model model){
        model.addAttribute("registerData", new UserRegisterDto());

        return "register";
    }
    @PostMapping("/register")
    private String doRegister (@Valid UserRegisterDto data,
                               BindingResult result,
                               RedirectAttributes redirectAttributes){
        if (result.hasErrors()){

            redirectAttributes.addFlashAttribute("registerData",data);
            return "register";
        }





            return "redirect:/users/login";
    }

    @GetMapping("/login")
    private String viewLogin(){
        return "login";
    }

}
