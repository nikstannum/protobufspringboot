package nkt.home.protobuf.repository.entity;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Course {
    private Integer id;
    private String courseName;
    private List<Student> students;
}
