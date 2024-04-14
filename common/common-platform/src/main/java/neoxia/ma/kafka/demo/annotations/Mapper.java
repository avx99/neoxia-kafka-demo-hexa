package neoxia.ma.kafka.demo.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Indicates that the annotated class is a mapper component responsible for mapping between
 * entities and DTOs (Data Transfer Objects) or between different domain objects.
 * This annotation serves as a stereotype annotation, similar to Spring's {@code @Component},
 * allowing automatic detection and registration of mapper components.
 * <p>
 * Mapper components are typically used to encapsulate the conversion logic between different
 * data models, such as converting database entities to DTOs for RESTful web services.
 * <p>
 * Example usage:
 * <pre>{@code
 *  \@Mapper
 *  public class UserMapper {
 *      // Mapping methods here
 *  }
 * }</pre>
 *
 * @see org.springframework.stereotype.Component
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Mapper {
}
