package nkt.home.protobuf.service;

import lombok.RequiredArgsConstructor;
import nkt.home.protobuf.generated.CourseProto.CourseDto;
import nkt.home.protobuf.mapper.Mapper;
import nkt.home.protobuf.repository.CourseRepository;
import nkt.home.protobuf.repository.entity.Course;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository repository;
    private final Mapper mapper;

    public CourseDto getById(Integer id) {
        Course course = repository.getCourse(id);
        return mapper.convert(course);
    }

    public CourseDto save(CourseDto courseDto) {
        Course course = mapper.convert(courseDto);
        Course created = repository.addCourse(course);
        return mapper.convert(created);
    }

//    public CourseDto getById(Integer id) {
//        Course course = repository.getCourse(id);
//        return toCourseDto(course);
//    }
//
//    private PhoneNumberDto toPhoneNumberDto(PhoneNumber phoneNumber) {
//        return PhoneNumberDto.newBuilder()
//                .setNumber(phoneNumber.getNumber())
//                .setType(PhoneTypeDto.valueOf(phoneNumber.getType().toString()))
//                .build();
//    }
//
//    private StudentDto toStudentDto(Student student) {
//        return StudentDto.newBuilder()
//                .setId(student.getId())
//                .setFirstName(student.getFirstName())
//                .setLastName(student.getLastName())
//                .setEmail(student.getEmail())
//                .addAllPhones(student.getPhones().stream()
//                        .map(this::toPhoneNumberDto)
//                        .toList())
//                .build();
//    }
//
//    private CourseDto toCourseDto(Course course) {
//        return CourseDto.newBuilder()
//                .setId(course.getId())
//                .setCourseName(course.getCourseName())
//                .addAllStudents(course.getStudents().stream()
//                        .map(this::toStudentDto)
//                        .toList())
//                .build();
//    }
}
