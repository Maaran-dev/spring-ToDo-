package SpringToDoApplication.ToDo.ToDoController;

import SpringToDoApplication.ToDo.ToDoService.UserService;
import SpringToDoApplication.ToDo.TodoRepository.UserRepository;
import SpringToDoApplication.ToDo.model.User;
import SpringToDoApplication.ToDo.utils.jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final jwt JwtTokenUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String,String > body) {
        String email = body.get("email");
        String password = passwordEncoder.encode(body.get("password"));

        if (userRepository.findByEmail(email).isPresent()) {
            return new ResponseEntity<String>("User already exists", HttpStatus.UNAUTHORIZED);
        }
        userService.CreateUser(User.builder().email(email).password(password).build());
        return new ResponseEntity<String>("User is register ", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> body) {
        String email = body.get("email");
        String password = body.get("password");

        var userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return new ResponseEntity<>("User not Register", HttpStatus.NOT_FOUND);
        }
        User user = userOptional.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return new ResponseEntity<>("Invalid User", HttpStatus.NOT_FOUND);
        }
        String token = JwtTokenUtil.generateToken(email);
        return ResponseEntity.ok(Map.of("Token", token));
    }

}
