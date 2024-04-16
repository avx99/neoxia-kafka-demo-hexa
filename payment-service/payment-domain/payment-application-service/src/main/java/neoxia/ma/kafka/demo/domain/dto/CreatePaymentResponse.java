package neoxia.ma.kafka.demo.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreatePaymentResponse {
    @NotNull
    private final String message;
    @NotNull
    private final String id;
}
