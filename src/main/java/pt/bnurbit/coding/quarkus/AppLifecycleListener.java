package pt.bnurbit.coding.quarkus;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

/**
 * StartupEvent and ShutdownEvent are marker interfaces
 * Annotation observes - look for events and when it is fired executes the method
 */
@ApplicationScoped
@Slf4j
public class AppLifecycleListener {

    public void onStart(@Observes StartupEvent startupEvent) {
        log.info("onStart executed");
    }

    public void onStart(@Observes ShutdownEvent shutdownEvent) {
        log.info("onStop executed");
    }
}
