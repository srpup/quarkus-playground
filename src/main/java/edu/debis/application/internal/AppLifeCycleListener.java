package edu.debis.application.internal;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.Optional;

@ApplicationScoped
public class AppLifeCycleListener {

    @ConfigProperty(name = "app.initiator")
    private Optional<String> account;

    public void onStart(@Observes StartupEvent event) {
        System.out.println("AppLifeCycleListener.onStart by " + account.orElse("Bot"));
    }

    public void onStop(@Observes ShutdownEvent event) {
        System.out.println("AppLifeCycleListener.onStop by " + account.orElse("Bot"));
    }
}
