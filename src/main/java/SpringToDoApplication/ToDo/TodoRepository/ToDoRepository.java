package SpringToDoApplication.ToDo.TodoRepository;

import SpringToDoApplication.ToDo.model.ToDo;
import SpringToDoApplication.ToDo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDo,Long> {

}
