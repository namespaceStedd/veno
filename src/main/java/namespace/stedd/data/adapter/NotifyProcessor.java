package namespace.stedd.data.adapter;

import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * Процессор обработки аннотаций @Notify.
 * @author Namespace Stedd
 */
@AutoService(AbstractProcessor.class)
public class NotifyProcessor extends AbstractProcessor {

    /**
     * Процессор обработки аннотаций @Notify.
     * @author Namespace Stedd
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            roundEnv.getElementsAnnotatedWith(Notify.class).forEach(element -> {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, element.getAnnotation(Notify.class).value());
            });
        }
        return false;
    }

}
