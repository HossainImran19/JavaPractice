package advance.java.imran.definition.syntax;


// Here we can not add multiple abstract methods
// because @FunctionalInterface is an interface where only one abs method can have.
// But there can be multiple methods and these are only 3 kind of methods
// 1. Default method
// 2. Static method
// 3. Methods which are inherited from Object class
@FunctionalInterface
public interface Converter<T> {

    String apply(String s);
}


