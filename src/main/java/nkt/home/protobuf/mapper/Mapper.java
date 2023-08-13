package nkt.home.protobuf.mapper;

import lombok.RequiredArgsConstructor;
import nkt.home.protobuf.generated.CourseProto.CourseDto;
import nkt.home.protobuf.repository.entity.Course;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper {
    private final CourseMapper courseMapper;

    public Course convert(CourseDto dto) {
        return courseMapper.toEntity(dto);
    }

    public CourseDto convert(Course course) {
        return courseMapper.toDto(course);
    }
}
