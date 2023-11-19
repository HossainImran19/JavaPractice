package advance.java.imran.f.lamda.advantages;

public class ScopingDemo {

    // In this case Anonymous Inner class can create its own scope.
    // Due to this it is possible to declare 2 variables with the same name 'hello'.
    public void method1() {
        String hello = "Hello World";
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String hello = "Hello Universe";
                System.out.println("hello");
            }
        };
    }

    // But in lamda expression we can not declare 2 variables with the same name.
    public void method2() {
        String hello = "Hello world";
        Runnable runnable = () -> {
//            String hello = "Hello Universe";
            System.out.println(hello);
        };
    }
}
