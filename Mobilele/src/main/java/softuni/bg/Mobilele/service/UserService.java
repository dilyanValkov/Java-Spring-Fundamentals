package softuni.bg.Mobilele.service;

import softuni.bg.Mobilele.model.dto.UserLoginDto;
import softuni.bg.Mobilele.model.dto.UserRegistrationDto;

public interface UserService {

    void registerUser(UserRegistrationDto userRegistrationDto);

    boolean login (UserLoginDto userLoginDto);
}
