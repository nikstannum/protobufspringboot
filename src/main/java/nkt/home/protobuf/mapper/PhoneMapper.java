package nkt.home.protobuf.mapper;

import nkt.home.protobuf.generated.CourseProto.StudentDto.PhoneNumberDto;
import nkt.home.protobuf.repository.entity.PhoneNumber;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

@Mapper
public interface PhoneMapper {
    PhoneNumberDto toDto(PhoneNumber phoneNumber);

    /*
    Note that the class generated from the proto-file has the UNRECOGNIZED enum. For him, the default mapping is specified on the null.

    Обратите внимание, что в сгенерированном из прото-файла классе есть перечисление UNRECOGNIZED. Для него указан дефолтный маппинг на null.
     */
    @ValueMapping(source = "UNRECOGNIZED", target = MappingConstants.NULL)
    PhoneNumber toEntity(PhoneNumberDto dto);
}
