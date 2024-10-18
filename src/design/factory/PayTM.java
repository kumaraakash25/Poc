package design.factory;

public class PayTM implements PaymentProcessor {
    @Override
    public void process(Payment payment) {
        System.out.println("Payment through PayTM"+ payment.id);
    }
}
