package advance.java.imran.b.definition.syntax.d.lamda.scope;

import java.util.function.Consumer;

public class ScopeTest {
    public static void main(String[] args) {
        // If we use lamda in a scope of a method
        // then it will be located in the method scope.
        // This scope is called 'Lexical Scope'.
        // If we try to compile this main method then
        // it will give us an error.
        // Because variable 'msg' is same to variable 'msg' of the lamda.
        String msg = "";
//        Consumer<String> consumer = msg -> System.out.println(msg);
        ScopeExample obj = new ScopeExample();
        obj.print();
    }
}

class ScopeExample {
    public int x = 0;

    // This is the example of variable shadowing.
    public void print() {
        int x = 1;
        System.out.println(x);
        System.out.println(this.x);
    }
}
