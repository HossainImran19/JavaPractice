package advance.java.imran.GUsesOfLamda.g.execute.around.method;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static advance.java.imran.GUsesOfLamda.g.execute.around.method.LockHelper.withLock;


// Execute pattern is used to remove the Boilerplate Codes in our business logic.
// For that we're using here some of functional interfaces and a helper Class.
// Interface is used for unique business logic.
// And helper class is used for writing boilerplate code.
public class IntStack {
    private Integer[] elements = new Integer[16];
    private Lock lock  = new ReentrantLock();
    private int size = -1;

    // Removing the boilerplate code to helper class
    public void push(Integer value) {
        LockHelper.withLock(lock, () -> {
            if (size++ >= elements.length)
                resize();
            elements[size] = value;
        });
    }

    public int pop() {
        return LockHelper.withLock(lock, () -> {
            Integer e = elements[--size];
            elements[size] = null;
            return e;
        });
    }

    public void resize() {

    }
}
