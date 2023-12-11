package advance.java.imran.CMethodReference.ATypesReferences.b.instance;

import java.util.function.Function;

public class InstanceRefExample {
    public static void main(String[] args) {
        String hello = "Hello World";

        StringUtil util = new StringUtil();

        MethodRefDemo.checker(hello, string -> util.isNotEmpty(string));
        MethodRefDemo.checker(hello, string -> util.hasSpecialChar(string));
    }

}

class StringUtil {
    public boolean isNotEmpty(String value) {
        return value != null && value.length() > 0;
    }

    public boolean isEmpty(String value) {
        return !isNotEmpty(value);
    }

    public boolean hasSpecialChar(String value) {
        return value.chars()
                .map(op -> (char)op)
                .allMatch(Character::isAlphabetic);
    }
}

class MethodRefDemo {
    public static void checker(String str, Function<String, Boolean> func) {
        System.out.println(func.apply(str));
    }
}
