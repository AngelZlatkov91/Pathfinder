package bg.softuni.workshopPathfinder.service.Impl;

import bg.softuni.workshopPathfinder.model.DTO.UserRegistrationDTO;
import bg.softuni.workshopPathfinder.model.entity.User;
import bg.softuni.workshopPathfinder.model.enums.LevelEnum;
import bg.softuni.workshopPathfinder.repository.UserRepository;
import bg.softuni.workshopPathfinder.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
        private final UserRepository userRepository;
     @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(UserRegistrationDTO registrationDTO) {
         if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
             throw new RuntimeException("passwords.match");
         }

        Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());
         if (byEmail.isPresent()) {
             throw new RuntimeException("email.used");
         }

         User user = new User(registrationDTO.getUsername(),registrationDTO.getPassword(),registrationDTO.getFullname()
         ,registrationDTO.getAge(),registrationDTO.getEmail());
           user.setLevel(LevelEnum.BEGINNER);
         this.userRepository.save(user);
    }
}
