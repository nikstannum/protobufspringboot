package nkt.home.protobuf.repository.entity;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<PhoneNumber> phones;
}
