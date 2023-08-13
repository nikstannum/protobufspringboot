package nkt.home.protobuf.mapper;

import nkt.home.protobuf.generated.CourseProto.StudentDto;
import nkt.home.protobuf.repository.entity.Student;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/*
Pay attention to the use of collections in the classes generated from proto-files. These collections are non-modifiable, so
to avoid runtime exceptions, you need to change the strategy for working with collections (collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
(see https://blog.devgenius.io/how-to-use-mapstruct-for-nested-protobuf-and-pojo-to-reduce-boilerplate-d3698e28c48b)

Обратите внимание на использование коллекций в сгенерированных из прото-файлов классах. Эти колекции являются немодифицируемыми, поэтому во
избежание исключительных ситуаций во время выполнения необходимо изменить стратегию работы с коллекциями (collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
(см. https://blog.devgenius.io/how-to-use-mapstruct-for-nested-protobuf-and-pojo-to-reduce-boilerplate-d3698e28c48b)
 */
@Mapper(uses = PhoneMapper.class, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface StudentMapper {
    @Mapping(source = "phones", target = "phonesList")
    StudentDto toDto(Student student);

    @Mapping(source = "phonesList", target = "phones")
    Student toEntity(StudentDto dto);
}
