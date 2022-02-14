package uz.pdp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.model.User;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CourseDto {
    private int id;
    private String name;
    private String description;
    private double price;
    private boolean isActive;
    private int[] authorId;
    private List<UserDto> author;
}
