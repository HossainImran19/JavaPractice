package advance.java.imran.BDefinitionSyntax.b.context.of.target.typing;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        // We can use lamda expression iff
        // by using the instance of a Functional interface.
        // Here Adder is a Functional interface
        // and target type is Adder.
        Adder adder1 = new AddImpl();
        // or
        Adder adder2 = (a, b) -> 2*a + 2*b;

        // This line is not a legal
        // because of the absent of target type.
        // It will cause a compiler error.
        // Object adder3 = (a, b) -> 3*a + 2*b; // illegal

        // we can use lamda in the various context.
        // 1. in the context variable declaration and assignment.
        Adder adder4 = Integer::sum;

        // 2. as a return statement.

        // 3. as a argument of a method or contractor.
        // Here is target type of lamda exp is the parameter type.
        ArrayList<String> list = new ArrayList<>();
        list.sort((string1, string2) -> string1.compareToIgnoreCase(string2));

        // 4. as the body of another lamda exp.
        // Where outer lamda target type and body lamda target will be same.
        Callable<Runnable> callable = () -> () -> System.out.println("Hello World");

        // 5. as a ternary exp.
        boolean flag = true;
        Callable<Integer> c2 = flag ? (() -> 102) : (() -> 100);

        // 6. as cast exp
        // The 2nd line is legal.
        // Because cast exp is providing the target type
        // Object o = () -> "hi"; // illegal
        Object s = (Supplier) () -> "hi"; // legal

    }
}
