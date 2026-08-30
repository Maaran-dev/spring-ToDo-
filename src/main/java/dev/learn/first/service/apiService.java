package dev.learn.first.service;

import dev.learn.first.model.toDo;
import dev.learn.first.repository.apiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class apiService {

    @Autowired
    private apiRepository ApiRepository;

    public toDo Createtodo(toDo todo) {
        return ApiRepository.save(todo);
    }

    public toDo getToDobyId(int id) {
        return ApiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDo Is not Found "));
    }

    public List<toDo> getalltodo() {
        return ApiRepository.findAll();
    }

    public toDo UpdateToDo(toDo todo){
        return ApiRepository.save(todo);
    }

    public void DeleteToDo(int id){
        ApiRepository.delete(ApiRepository.getById(id));
//        here we use the both type to delete the data
//        toDo todo = ApiRepository.getReferenceById(id);
//        ApiRepository.delete(todo);
    }
}
