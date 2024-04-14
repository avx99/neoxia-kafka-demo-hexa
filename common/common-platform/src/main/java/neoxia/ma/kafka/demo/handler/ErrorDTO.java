package neoxia.ma.kafka.demo.handler;

import lombok.Builder;

@Builder
public record ErrorDTO(String code, String message) {
}
