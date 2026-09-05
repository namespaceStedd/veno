package namespace.stedd.data.adapter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Управление уведомлениями.
 * @author Namespace Stedd
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,
        ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER, TYPE_USE, MODULE, RECORD_COMPONENT})
public @interface Notify {

    /**
     * Сообщение, выводимое в уведомлении.
     * @author Namespace Stedd
     * @return сообщение, выводимое в уведомлении
     */
    String value();

}
