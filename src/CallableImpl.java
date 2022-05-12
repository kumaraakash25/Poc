import java.util.concurrent.Callable;

public class CallableImpl implements Callable<Double> {
    @Override
    public Double call() {
        return Math.random();
    }
}
