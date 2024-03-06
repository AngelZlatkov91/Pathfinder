package bg.softuni.workshopPathfinder.web;

import bg.softuni.workshopPathfinder.model.DTO.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {



     @GetMapping("/register")
    public String register() {
        return"register";
    }

    @PostMapping("/register")
    public String doRegister (UserRegistrationDTO userRegistrationDTO) {

         return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){

         return "login";
    }


}
