package uz.pdp.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectDto {
    private int id;
    private String name;
    private String courseName;
    private String description;
}
