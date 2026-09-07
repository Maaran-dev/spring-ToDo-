package SpringToDoApplication.ToDo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ToDo {
@Id
@GeneratedValue
private Long id;
private String title;
private String description;
private boolean isComplete;
}
