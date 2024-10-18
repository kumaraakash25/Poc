package design.strategy;

import java.util.HashMap;
import java.util.Map;

public class TrackingStrategy {

    Map<String, Tracking> map;

    TrackingStrategy() {
        map = new HashMap<>();
        map.put("AIR", new AirTracking());
        map.put("GROUND", new GroundTracking());
    }

    public Tracking getStrategy(String strategy) {
        return map.get(strategy);
    }
}
