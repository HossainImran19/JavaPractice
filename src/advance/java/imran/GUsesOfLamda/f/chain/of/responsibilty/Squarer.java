package advance.java.imran.GUsesOfLamda.f.chain.of.responsibilty;

public class Squarer extends ProcessingObject<Integer> {
    @Override
    protected Integer handleWork(Integer input) {
        return input * input;
    }
}
