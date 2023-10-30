package advance.java.imran.b.definition.syntax.a.target.typing;

public class Main {
    public static void main(String[] args) {

        //the following line is a poly expression because
        // 1. Converter is a Functional Interface
        // 2. matching the parameter list of lamda with the abstract method of interface
        // 3. matching the return type of lamda with the abst method of interface
        // 4. matching with checked expression of lamda with the abs method of interface
        Converter upperCaseConverter = string -> string.toUpperCase();

        String helloWorld = upperCaseConverter.apply("hello world");
        System.out.println(helloWorld);

        // another implementation Converter interface
        // for Title Case Conversion
        Converter titleCaseConverter = string -> {
            StringBuilder sb = new StringBuilder();
            boolean nextTitleCase = true;

            for (char c : string.toCharArray()) {
                if (Character.isSpaceChar(c)) {
                    nextTitleCase = true;
                } else if (nextTitleCase) {
                    c = Character.toTitleCase(c);
                    nextTitleCase = false;
                }
                sb.append(c);
            }
            return sb.toString();
        };

        System.out.println(titleCaseConverter.apply("i mran"));
    }
}
