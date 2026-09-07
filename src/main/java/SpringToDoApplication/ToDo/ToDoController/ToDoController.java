package SpringToDoApplication.ToDo.ToDoController;

import SpringToDoApplication.ToDo.ToDoService.ToDoService;
import SpringToDoApplication.ToDo.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @PostMapping("/create")
    ResponseEntity<ToDo> CreateToDo(@RequestBody ToDo toDo){
        return new ResponseEntity<>(toDoService.CreateToDo(toDo), HttpStatus.CREATED);
    }
    @GetMapping
    ResponseEntity<List<ToDo>> getAllToDo(){
       try {
           return new ResponseEntity<>(toDoService.alltodo(),HttpStatus.FOUND);
       } catch (RuntimeException e) {
           throw new RuntimeException(e);
       }
    }


}
