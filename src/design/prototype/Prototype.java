package design.prototype;

public abstract class Prototype<T> implements Cloneable {
    public T copy() throws CloneNotSupportedException {
        return (T)super.clone();
    }
}
