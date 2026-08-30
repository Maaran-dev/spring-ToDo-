package dev.learn.first.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

import javax.annotation.processing.Generated;
@Entity
@Data
public class toDo {
    @Id
    @GeneratedValue
    int id;
    String title;
    String Description;
    Boolean isComplete;

}
