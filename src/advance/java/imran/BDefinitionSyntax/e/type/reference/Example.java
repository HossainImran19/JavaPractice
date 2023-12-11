package advance.java.imran.BDefinitionSyntax.e.type.reference;

import advance.java.imran.BDefinitionSyntax.b.context.of.target.typing.Adder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example {
    Map < String, List < String > > map = new HashMap < String, List< String > >();

    // After adding diamond operator we can like that....
    Map < String, List < String > > map1 = new HashMap<>();

    // Like that java can understand type information in lamda also.
    // So here in the add we didn't declare types of the parameters explicitly.
    // Java comp can find out the types from the target type of lamda.

    // here adder and adder1 is same but
    // when the body of lamda have only one statement then
    // it is not necessary to use carli braces and do not need to write return key word.
    Adder adder = (a, b) -> a+b;
    Adder adder1 = (a, b) -> {
        return a+b;
    };

    // We have to use parentheses only
    // when the number of parameters either zero or more than 1 parameter.
    Runnable runnable = () -> {
        System.out.println("Hellow");
    };
}
