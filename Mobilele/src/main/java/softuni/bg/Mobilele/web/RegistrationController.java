package softuni.bg.Mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.bg.Mobilele.model.dto.UserRegistrationDto;
import softuni.bg.Mobilele.service.UserService;

@Controller
@RequestMapping("/users")
public class RegistrationController {


    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerDto")
    public UserRegistrationDto registerDto(){
        return new UserRegistrationDto();
    }


    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("/register")
    public String doRegister(UserRegistrationDto userRegistrationDto){

        userService.registerUser(userRegistrationDto);
        return "redirect:/";

    }
}
