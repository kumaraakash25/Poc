package design.factory;

import java.util.Scanner;

public class TestFactory {
    public static void main(String[] args) {
        PaymentProcessorFactory factory = new PaymentProcessorFactory();
        PaymentProcessor p = factory.getFactory("PAYTM");
        p.process(new Payment(1L));
    }
}
