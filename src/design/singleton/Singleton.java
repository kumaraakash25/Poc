package design.singleton;

public final class Singleton {

    // You cannot initialise this private constructor
    private Singleton() {
    }

    // Any change to variable is visible to all the threads
    public static volatile Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
