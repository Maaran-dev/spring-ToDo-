package dev.learn.first;

import dev.learn.first.model.toDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class apiController {
    @Autowired
    private apiService ApiService;

    @PostMapping("/create")
    ResponseEntity<toDo> Createtodo(@RequestBody toDo todo){
         return new ResponseEntity<>(ApiService.Createtodo(todo),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    ResponseEntity<toDo> gettoDobyId(@PathVariable int id) {
        try {
            toDo todo = ApiService.getToDobyId(id);
            return new ResponseEntity<>(todo, HttpStatus.FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    ResponseEntity<List<toDo>> getalltodos(){
            return new ResponseEntity<List<toDo>>(ApiService.getalltodo(),HttpStatus.OK);
        }
    }




