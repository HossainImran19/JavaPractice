package advance.java.imran.b.definition.syntax.d.lamda.scope;

import java.util.function.Consumer;

public class ScopeTest {
    public static void main(String[] args) {
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
