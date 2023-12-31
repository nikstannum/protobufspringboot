package nkt.home.protobuf.repository;

import java.util.Map;
import nkt.home.protobuf.repository.entity.Course;

public class CourseRepository {
    Map<Integer, Course> courses;

    /*
    because when creating a bean, we already have a collection filled with two courses.

    т.к. при создании бина у нас уже заполнена коллекция двумя курсами.
     */
    private int counter = 2;

    public CourseRepository(Map<Integer, Course> courses) {
        this.courses = courses;
    }

    public Course getCourse(int id) {
        return courses.get(id);
    }

    public Course addCourse(Course entity) {
        counter++;
        Course course = Course.builder()
                .id(counter)
                .courseName(entity.getCourseName())
                .students(entity.getStudents())
                .build();
        courses.put(counter, course);
        return course;
    }
}
