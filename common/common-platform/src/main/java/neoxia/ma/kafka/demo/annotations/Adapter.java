package neoxia.ma.kafka.demo.annotations;

import neoxia.ma.kafka.demo.utils.PortType;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Indicates that the annotated class is an adapter class, which serves as an interface between
 * external systems or components and the application's core logic within a hexagonal architecture.
 * Adapter classes typically implement ports in a hexagonal architecture, facilitating communication
 * between the application and its surrounding environment.
 * <p>
 * This annotation can be used to mark adapter classes for documentation and runtime processing.
 * When applied to a class, it allows for easier identification and categorization of adapter
 * components within a software system.
 * <p>
 * Example:
 * <pre>
 *     &#064;Adapter(type = PortType.INPUT)
 *     public class InputAdapter {
 *         // Methods to handle incoming data from external systems
 *     }
 * </pre>
 * <p>
 * This annotation is typically used in conjunction with Spring Framework's component scanning
 * mechanism to automatically detect and register adapter classes as beans within the application
 * context.
 * <p>
 * The {@code type} attribute of this annotation allows specifying the port type, which can be
 * either {@code PortType.INPUT} or {@code PortType.OUTPUT}. This provides flexibility in
 * distinguishing between input and output ports within the hexagonal architecture.
 * <p>
 * Note: This annotation is meta-annotated with Spring's {@code @Component} annotation to
 * enable automatic detection and registration of adapter classes as Spring beans.
 * <p>
 * <b>Retention Policy:</b> {@code RUNTIME}
 * <b>Target:</b> {@code TYPE}
 * <b>Documented:</b> Yes
 * <b>Inherited:</b> No
 * <b>Thread Safety:</b> This annotation is not inherently thread-safe. It is the responsibility
 * of the user to ensure that the annotated classes and their usage are thread-safe.
 *
 * @see org.springframework.stereotype.Component
 * @see java.lang.annotation.Documented
 * @see java.lang.annotation.ElementType
 * @see java.lang.annotation.RetentionPolicy
 * @see PortType
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Adapter {
    PortType type() default PortType.OUTPUT;
}
