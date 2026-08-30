package dev.learn.first.repository;

import dev.learn.first.model.toDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public  interface apiRepository extends JpaRepository<toDo,Integer>  {

}
