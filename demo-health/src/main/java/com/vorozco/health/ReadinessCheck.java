package com.vorozco.health;

import org.eclipse.microprofile.health.*;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

@Liveness
@ApplicationScoped
public class ReadinessCheck implements HealthCheck {

    int count;

    Logger LOGGER = Logger.getLogger("Liveness log");

    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder healthCheck = HealthCheckResponse.builder()
                .name("vorozcocheck")
                .withData("FavLang", "java")
                .withData("Executions", ++count);

        LOGGER.warning("Execution " + count);

        if(count < 10){
            return healthCheck.up().build();
        }else{
            return healthCheck.down().build();
        }
    }
}
