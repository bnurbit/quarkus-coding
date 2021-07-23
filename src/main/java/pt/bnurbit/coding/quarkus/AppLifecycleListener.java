package pt.bnurbit.coding.quarkus;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;

/**
 * StartupEvent and ShutdownEvent are marker interfaces
 * Annotation observes - look for events and when it is fired executes the method
 */
@ApplicationScoped
public class AppLifecycleListener {

    public static final Logger LOGGER = Logger.getLogger("Lifecycle");

    public void onStart(@Observes StartupEvent startupEvent) {
        LOGGER.info("onStart executed");
    }

    public void onStart(@Observes ShutdownEvent shutdownEvent) {
        LOGGER.info("onStop executed");
    }
}
