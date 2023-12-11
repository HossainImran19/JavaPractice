package advance.java.imran.HAdvanceGenerics.AGenericsInheritanceSubTyping;

public class Holder<T> {
    private T object;

    public T getObject() {
        return object;
    }

    public Holder<T> setObject(T object) {
        this.object = object;
        return this;
    }
}
