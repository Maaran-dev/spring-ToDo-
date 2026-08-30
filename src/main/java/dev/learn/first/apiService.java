package dev.learn.first;

import dev.learn.first.model.toDo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class apiService {

    @Autowired
    private apiRepository ApiRepository;

    public  toDo  Createtodo(toDo todo){
      return ApiRepository.save(todo);
    }
    public toDo getToDobyId(int id){
       return ApiRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("ToDo Is not Found "));
    }
    public List<toDo> getalltodo(){
        return ApiRepository.findAll();
    }





}
