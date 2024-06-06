package softuni.bg.Mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.bg.Mobilele.model.dto.UserLoginDto;
import softuni.bg.Mobilele.service.UserService;

@Controller
@RequestMapping("/users")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login (){
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(UserLoginDto userLoginDto){
        userService.login(userLoginDto);
        return "redirect:/";
    }

}
