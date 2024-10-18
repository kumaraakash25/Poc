package design.strategy;

public class Test {
    public static void main(String[] args) {
        TrackingStrategy strategy = new TrackingStrategy();

        Tracking tracking = strategy.getStrategy("AIR");
        tracking.track();
    }

}
