package SpringToDoApplication.ToDo.ToDoService;

import SpringToDoApplication.ToDo.TodoRepository.ToDoRepository;
import SpringToDoApplication.ToDo.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public ToDo CreateToDo(ToDo todo){
        return toDoRepository.save(todo);
    }

    public ToDo findById(long id) {
        return toDoRepository.findById(id).orElse(null);
    }
    public List<ToDo> alltodo(){
        return toDoRepository.findAll();
    }



}
