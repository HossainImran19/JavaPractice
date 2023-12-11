package advance.java.imran.GUsesOfLamda;


import java.util.ArrayList;
import java.util.List;

// This is the client class
public class CommandPattern {
    public static void main(String[] args) {
        // Creating Receiver object
        Tv tv = new Tv();

        // Creating Invoker object
        RemoteControl control = new RemoteControl();

        // Passing objects of the implementations of Command interface
        // using Lamda expression or Method Reference.
        // Here we don't need to create any implementation
        // like 'OnCommand' and 'OffCommand' classes
        // of the Command interface.
        control.press(tv::switchOn);
        control.press(tv::switchOff);
    }
}

// Command interface is the most important interface
// in this design pattern.
// This interface also a Functional Interface.
interface Command {
    void execute();
}

// Tv class is a receiver class
class Tv {
    public void switchOn() {
        System.out.println("Switch ON");
    }
    public void switchOff() {
        System.out.println("Switch OFF");
    }
}

// RemoteControl class is an invoker class.
class RemoteControl {
    private List<Command> history
            = new ArrayList<>();

    public void press(Command command) {
        history.add(command);
        command.execute();
    }
}