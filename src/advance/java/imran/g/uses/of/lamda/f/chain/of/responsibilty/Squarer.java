package advance.java.imran.g.uses.of.lamda.f.chain.of.responsibilty;

public class Squarer extends ProcessingObject<Integer> {
    @Override
    protected Integer handleWork(Integer input) {
        return input * input;
    }
}
