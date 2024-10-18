package design.cor;

public interface Handler {
    public void handle();
    public void nextHandler(Handler next);
}
