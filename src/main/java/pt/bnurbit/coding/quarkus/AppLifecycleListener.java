package pt.bnurbit.coding.quarkus;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;

@ApplicationScoped
public class AppLifecycleListener {

    public static final Logger LOGGER = Logger.getLogger("Lifecycle");

    public void onStart(@Observes StartupEvent startupEvent){
        LOGGER.info("onStart executed");
    }

    public void onStart(@Observes ShutdownEvent shutdownEvent){
        LOGGER.info("onStop executed");
    }
}
