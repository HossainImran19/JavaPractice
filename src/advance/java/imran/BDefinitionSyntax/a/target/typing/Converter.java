package advance.java.imran.BDefinitionSyntax.a.target.typing;


// Here we can not add multiple abstract methods
// because @FunctionalInterface is an interface where only one abs method can have.
// But there can be multiple methods and these are only 3 kind of methods
// 1. Default method
// 2. Static method
// 3. Methods which are inherited from Object class
@FunctionalInterface
public interface Converter<T> {

    // only one abstract method should be allowed
    String apply(String s);

    static Integer add(int a, int b) {
        return a + b;
    }
    boolean equals(Object obj);


}


