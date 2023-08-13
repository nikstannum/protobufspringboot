package nkt.home.protobuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nkt.home.protobuf.generated.CourseProto.Course;
import nkt.home.protobuf.generated.CourseProto.Student;
import nkt.home.protobuf.repository.CourseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@SpringBootApplication
public class ProtobufApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtobufApplication.class, args);
	}

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    @Bean
    public CourseRepository createTestCourses() {
        Map<Integer, Course> courses = new HashMap<>();
        Course course1 = Course.newBuilder()
                .setId(1)
                .setCourseName("REST with Spring")
                .addAllStudent(createTestStudents())
                .build();
        Course course2 = Course.newBuilder()
                .setId(2)
                .setCourseName("Learn Spring Security")
                .addAllStudent(new ArrayList<>())
                .build();
        courses.put(course1.getId(), course1);
        courses.put(course2.getId(), course2);
        return new CourseRepository(courses);
    }

    private List<Student> createTestStudents() {
        return Arrays.asList(
                Student.newBuilder()
                        .setId(1)
                        .setFirstName("John")
                        .setLastName("Doe")
                        .setEmail("johndoe@example.com")
                        .addPhone(Student.PhoneNumber.newBuilder()
                                .setNumber("555-1234")
                                .setType(Student.PhoneType.MOBILE))
                        .build(),
                Student.newBuilder()
                        .setId(2)
                        .setFirstName("Jane")
                        .setLastName("Doe")
                        .setEmail("janedoe@example.com")
                        .addPhone(Student.PhoneNumber.newBuilder()
                                .setNumber("555-5678")
                                .setType(Student.PhoneType.LANDLINE))
                        .build()
        );
    }
}
