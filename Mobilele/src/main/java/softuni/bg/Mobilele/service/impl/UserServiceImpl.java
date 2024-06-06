package softuni.bg.Mobilele.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.Mobilele.model.CurrentUser;
import softuni.bg.Mobilele.model.dto.UserLoginDto;
import softuni.bg.Mobilele.model.dto.UserRegistrationDto;
import softuni.bg.Mobilele.model.entity.UserEntity;
import softuni.bg.Mobilele.repository.UserRepository;
import softuni.bg.Mobilele.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDto userRegistrationDto) {
            userRepository.save(map(userRegistrationDto));
    }

    @Override
    public boolean login(UserLoginDto userLoginDto) {


        UserEntity userEntity = this.userRepository.findByEmail(userLoginDto.email()).orElse(null);


        if (userLoginDto.password() == null || userEntity == null || userEntity.getPassword() == null){
            return false;
        }
        boolean success = passwordEncoder.matches(userLoginDto.password(), userEntity.getPassword());

        if (success){
            currentUser.setLoggedIn(true);
            currentUser.setFullName(userEntity.getFirstName() + " " + userEntity.getLastName());
        }else {
            currentUser.clean();
        }
        return false;
    }

    private UserEntity map(UserRegistrationDto userRegistrationDto ){

        UserEntity mapped = modelMapper.map(userRegistrationDto, UserEntity.class);

        mapped.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));

        return mapped;
    }
}
