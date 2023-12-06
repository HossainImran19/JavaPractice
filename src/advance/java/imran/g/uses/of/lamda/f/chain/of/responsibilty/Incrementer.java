package advance.java.imran.g.uses.of.lamda.f.chain.of.responsibilty;

public class Incrementer extends ProcessingObject<Integer> {
    @Override
    protected Integer handleWork(Integer input) {
        return input + 1;
    }
}
