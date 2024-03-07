package bg.softuni.workshopPathfinder.service;

import bg.softuni.workshopPathfinder.model.DTO.UserRegistrationDTO;

public interface AuthService {

    void register(UserRegistrationDTO registrationDTO);
}
