package design.strategy;

public class AirTracking implements Tracking{
    @Override
    public void track() {
        System.out.println("Air tracking");
    }
}
