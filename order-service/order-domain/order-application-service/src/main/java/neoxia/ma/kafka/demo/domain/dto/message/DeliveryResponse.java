package neoxia.ma.kafka.demo.domain.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DeliveryResponse {
    private String id;
    private String message;
    private String code;
    private Boolean delivered;
}
