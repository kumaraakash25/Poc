package design.factory;

public class PaymentProcessorFactory {
    public PaymentProcessor getFactory(String processor) {
        switch (processor) {
            case "PAYTM":
                return new PayTM();
            case "RZ":
                return new RazorPay();
            default:
                throw new RuntimeException("no factory");
        }
    }
}
