package SpringToDoApplication.ToDo.ToDoController;

import SpringToDoApplication.ToDo.ToDoService.UserService;
import SpringToDoApplication.ToDo.TodoRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final UserRepository userRepository;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String,String > body) {
       String email=body.get("email");
       String password=body.get("password");

       if(userRepository.findByEmail(email).isPresent()){
           return new ResponseEntity<String>("User already exists", HttpStatus.UNAUTHORIZED);
       }
       userService.CreateUser()
    }

}
