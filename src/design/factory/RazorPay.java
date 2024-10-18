package design.factory;

public class RazorPay implements PaymentProcessor {
    @Override
    public void process(Payment payment) {
        System.out.println("Payment through RazorPay"+ payment.id);
    }
}
