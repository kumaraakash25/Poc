package design.cor;

public class Test {
    public static void main(String[] args) {
        SecondHandler secondHandler = new SecondHandler();
        FirstHandler handler = new FirstHandler();

        handler.nextHandler(secondHandler);
    }
}
