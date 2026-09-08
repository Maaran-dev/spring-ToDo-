package SpringToDoApplication.ToDo.ToDoService;
import SpringToDoApplication.ToDo.TodoRepository.UserRepository;
import SpringToDoApplication.ToDo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public User CreateUser(User user){
        return userRepository.save(user);
    }

    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    
}
