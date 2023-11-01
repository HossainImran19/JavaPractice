package advance.java.imran.b.definition.syntax.c.variable.capturing;

import java.util.List;

public class EmailSender {
    public static void main(String[] args) {

        // We can say from pure Functional Programming that
        // lamda won't make any side effect.
        // That's mean it won't make any modifications of any variables or instances of its scope.

        // Final
        // If we want to make immutable to a variable
        // we have to declare the variable as final.
        final String banglaMsg = "বাংলাদেশ";

        // Effectively final because
        // it assigned to only once and never modified after that.
        // It can be captured by lambda expressions and anonymous inner classes.
        String englishMsg = "Bangladesh";

        MessageTranslator translator
                = msg -> banglaMsg.equals(msg) ? englishMsg : "Unknown";

        EmailSender emailSender
                = new EmailSender();
        emailSender.send(translator, "বাংলাদেশ");
    }

    public void send(MessageTranslator translator,
                     String msg) {
        String translated
                = translator.translate(msg);
        System.out.println("Sending email with translated message " + translated);
    }

    public void exampleOfMultithreading(List<Integer> list) {
        // This code is not valid.
        // Because lamda trying to change the value of 'sum'
        // If we run this method in a multithreaded program
        // we need to syncronize to the variable of 'sum'.
        // If we syncronize the variable then
        // it will not give us the proper benefits of multithreading.
        int sum = 0;
        list.forEach(value -> {
            sum += value;
        });
    }
}
