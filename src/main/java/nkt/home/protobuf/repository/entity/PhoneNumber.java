package nkt.home.protobuf.repository.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneNumber {
    private String number;
    private PhoneType type;

    public enum PhoneType {
        MOBILE, LANDLINE
    }
}
