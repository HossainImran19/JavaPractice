package advance.java.imran.definition.syntax;

public class Main {
    public static void main(String[] args) {
        Converter upperCaseConverter = (String s) -> s.toUpperCase();
        String helloWorld = upperCaseConverter.apply("hello world");
        System.out.println(helloWorld);

        Converter titleCaseConverter = (String st) -> {
            StringBuilder sb = new StringBuilder();
            boolean nextTitleCase = true;

            for (char c : st.toCharArray()) {
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
