package advance.java.imran.g.uses.of.lamda.f.chain.of.responsibilty;

import java.util.function.UnaryOperator;

public class ChainOfResponsibiltyDemo {
    public static void main(String[] args) {
        // without Lamda expressions
        ProcessingObject<Integer> squarer = new Squarer();
        ProcessingObject<Integer> incrementer = new Incrementer();

        squarer.setSuccessor(incrementer);

        Integer result = squarer.handle(4);


        System.out.println(result);

        // With Lamda expression
        UnaryOperator<Integer> squarerWithLamda = a -> a * a;
        UnaryOperator<Integer> incrementerWithLamda = a -> a + 1;

        Integer resultWithLamda = squarerWithLamda.andThen(incrementerWithLamda).apply(4);
        System.out.println(resultWithLamda);
    }
}
