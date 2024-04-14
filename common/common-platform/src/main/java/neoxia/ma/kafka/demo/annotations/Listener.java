package neoxia.ma.kafka.demo.annotations;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * Indicates that the annotated class is a listener class, designed to handle specific
 * events or messages within an application. Listener classes often implement interfaces
 * or extend classes provided by event-driven frameworks to receive and process events
 * asynchronously.
 * <p>
 * This annotation can be used to mark listener classes for documentation and runtime processing.
 * When applied to a class, it allows for easier identification and categorization of listener
 * components within a software system.
 * <p>
 * Example:
 * <pre>
 *     &#064;Listener
 *     public class MessageListener {
 *         // Methods to handle incoming messages
 *     }
 * </pre>
 * <p>
 * This annotation is typically used in conjunction with Spring Framework's component scanning
 * mechanism to automatically detect and register listener classes as beans within the application
 * context.
 * <p>
 * Note: This annotation is meta-annotated with Spring's {@code @Service} annotation to
 * enable automatic detection and registration of listener classes as Spring beans.
 * <p>
 * <b>Retention Policy:</b> {@code RUNTIME}
 * <b>Target:</b> {@code TYPE}
 * <b>Documented:</b> Yes
 * <b>Inherited:</b> No
 * <b>Thread Safety:</b> This annotation is not inherently thread-safe. It is the responsibility
 * of the user to ensure that the annotated classes and their usage are thread-safe.
 *
 * @see org.springframework.stereotype.Service
 * @see java.lang.annotation.Documented
 * @see java.lang.annotation.ElementType
 * @see java.lang.annotation.RetentionPolicy
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface Listener {
}
