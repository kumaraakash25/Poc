package design.strategy;

public class GroundTracking implements Tracking{
    @Override
    public void track() {
        System.out.println("Ground racking");
    }
}
