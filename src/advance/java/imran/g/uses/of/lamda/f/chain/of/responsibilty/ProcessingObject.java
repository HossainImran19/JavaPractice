package advance.java.imran.g.uses.of.lamda.f.chain.of.responsibilty;

// This class represents the processing object
public abstract class ProcessingObject<T> {
    protected ProcessingObject<T> successor;
    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T t = handleWork(input);

        // Passing the value of 't' for the next operation
        // that is described in the successor object.
        // In this case successor is an incrementer object.
        if (successor != null)
            return successor.handle(t);
        // when successor have no instance value
        // then it will return the result.
        return t;
    }

    protected abstract T handleWork(T input);
}
