package nkt.home.protobuf.controller;

import java.net.URI;
import nkt.home.protobuf.generated.CourseProto.Course;
import nkt.home.protobuf.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseRepository repository;

    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Integer id) {
        Course course = repository.getCourse(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(course);
    }

    /*
    In this method, the object of the Course class contains the id, but the logic for assigning the id is contained
    in the repository and is assigned to the counter.

    В данном методе объект класса Course содержит id, но логика присваивания id содержится в репозитории и возложена на счетчик.
     */
    @PostMapping
    public ResponseEntity<Course> save(@RequestBody Course course) {
        Course created = repository.addCourse(course);
        return buildResponseCreated(created);
    }

    private ResponseEntity<Course> buildResponseCreated(Course created) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(getLocation(created))
                .contentType(MediaType.APPLICATION_JSON) // нужно явно указать тип контента
                .body(created);
    }

    private URI getLocation(Course created) {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("courses/{id}")
                .buildAndExpand(created.getId())
                .toUri();
    }
}
