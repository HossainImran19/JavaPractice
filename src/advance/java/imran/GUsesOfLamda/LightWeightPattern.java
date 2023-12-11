package advance.java.imran.GUsesOfLamda;

public class LightWeightPattern {
    public static void main(String[] args) {

        var communicationService = new CommunicationService();

        // Without lamda expression
        var email = new Email();
        communicationService.setCommunicable(email);

        // With Lamda expression
        communicationService.setCommunicable(
                (des, msg) -> "Communicating via email -> sending message to -> "
                        + "destination [" + des + "], message: ["
                        + msg + "]"
        );
        communicationService.sendMessage(
                "irman@gmail.com",
                "Hello Imran with email"
        );
        //With Lamda expression
        communicationService.setCommunicable(
                (des, msg) -> "Communicating via phone call -> sending message to -> "
                        + "destination [" + des + "], message: ["
                        + msg + "]"
        );
        communicationService.sendMessage(
                "01576767357",
                "Hello Imran with phone call"
        );
    }
}


class CommunicationService {
    private Communicable communicable;

    public void setCommunicable(Communicable communicable) {
        this.communicable = communicable;
    }

    public void sendMessage(String des, String msg) {
        var log = communicable.communicate(des, msg);
        System.out.println(log);
    }
}

@FunctionalInterface
interface Communicable {
    String communicate(String destination, String msg);
}

class Email implements Communicable {

    @Override
    public String communicate(String destination, String msg) {
        return "Communicating via email -> sending message to "
                + "destination [" + destination + "], message: ["
                + msg + "]";
    }
}

class PhoneCall implements Communicable {

    @Override
    public String communicate(String destination, String msg) {
        return "Communicating via phoneCall -> sending message to "
                + "destination [" + destination + "], message: ["
                + msg + "]";
    }
}

class VideoCall implements Communicable {

    @Override
    public String communicate(String destination, String msg) {
        return "Communicating via videoCall -> sending message to "
                + "destination [" + destination + "], message: ["
                + msg + "]";
    }
}
