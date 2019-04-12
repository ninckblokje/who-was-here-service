package ninckblokje.bnb.whowashere.actuator;

import ninckblokje.bnb.whowashere.controller.WhoWasHereController;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class WhoWasHereHealthCheck implements HealthIndicator {

    private WhoWasHereController controller;
    private long injectionDateTime;

    public WhoWasHereHealthCheck(WhoWasHereController controller) {
        this.controller = controller;
        injectionDateTime = System.currentTimeMillis();
    }

    @Override
    public Health health() {
        if (injectionDateTime + 25000 <= System.currentTimeMillis()) {
            return Health.up().build();
        } else {
            return Health.down().build();
        }
    }
}
