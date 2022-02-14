package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private int id;
    private String name;
    private String description;
    private double price;
    private boolean isActive;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private List<User> author;
}
