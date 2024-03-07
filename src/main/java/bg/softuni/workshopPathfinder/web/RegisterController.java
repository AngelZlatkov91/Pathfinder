package bg.softuni.workshopPathfinder.web;
import bg.softuni.workshopPathfinder.model.DTO.UserRegistrationDTO;
import bg.softuni.workshopPathfinder.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    private AuthService authService;

    @Autowired
    public RegisterController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("userRegistrationDTO")
        public UserRegistrationDTO initForm(){
            return new UserRegistrationDTO();
        }

     @GetMapping("/register")
    public String register() {
        return"register";
    }

    @PostMapping("/register")
    public String doRegister (@Valid UserRegistrationDTO userRegistrationDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
         if (bindingResult.hasErrors()) {
             redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO",bindingResult);
             redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);
             return "redirect:/register";
         }
         this.authService.register(userRegistrationDTO);

         return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){

         return "login";
    }


}
