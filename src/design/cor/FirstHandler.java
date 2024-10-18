package design.cor;

public class FirstHandler implements Handler {

    Handler next;
    @Override
    public void handle() {
        if (true) {
            // If first handler can handle then fine
        } else {
            next.handle();
        }
    }
    @Override
    public void nextHandler(Handler next) {
        this.next = next;
    }
}
