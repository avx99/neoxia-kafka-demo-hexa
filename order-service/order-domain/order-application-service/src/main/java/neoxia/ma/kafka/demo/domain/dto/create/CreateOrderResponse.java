package neoxia.ma.kafka.demo.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import neoxia.ma.kafka.domain.valueobject.OrderStatus;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderResponse {
    @NotNull
    private final OrderStatus orderStatus;
    @NotNull
    private final String message;
    @NotNull
    private final String id;
}
