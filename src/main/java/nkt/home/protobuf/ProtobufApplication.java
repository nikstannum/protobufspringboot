package nkt.home.protobuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nkt.home.protobuf.repository.CourseRepository;
import nkt.home.protobuf.repository.entity.Course;
import nkt.home.protobuf.repository.entity.PhoneNumber;
import nkt.home.protobuf.repository.entity.PhoneNumber.PhoneType;
import nkt.home.protobuf.repository.entity.Student;
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
        Course course1 = Course.builder()
                .id(1)
                .courseName("REST with Spring")
                .students(createTestStudents())
                .build();
        Course course2 = Course.builder()
                .id(2)
                .courseName("Learn Spring Security")
                .students(new ArrayList<>())
                .build();
        courses.put(course1.getId(), course1);
        courses.put(course2.getId(), course2);
        return new CourseRepository(courses);
    }

    private List<Student> createTestStudents() {
        return Arrays.asList(
                Student.builder()
                        .id(1)
                        .firstName("John")
                        .lastName("Doe")
                        .email("johndoe@example.com")
                        .phones(Collections.singletonList(PhoneNumber.builder()
                                .number("555-1234")
                                .type(PhoneType.MOBILE).build()))
                        .build(),
                Student.builder()
                        .id(2)
                        .firstName("Jane")
                        .lastName("Doe")
                        .email("janedoe@example.com")
                        .phones(Collections.singletonList(PhoneNumber.builder()
                                .number("555-5678")
                                .type(PhoneType.LANDLINE).build()))
                        .build()
        );
    }
}
