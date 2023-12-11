package advance.java.imran.GUsesOfLamda.e.builder;

import java.util.function.Consumer;

import static advance.java.imran.GUsesOfLamda.e.builder.Processor.processor;

public class Computer {
    private final Disk disk;
    private final Processor processor;

    public Computer(Disk disk, Processor processor) {
        this.disk = disk;
        this.processor = processor;
    }

    public static void create(Consumer<ComputerBuilder> builder) {
        builder.accept(processor -> disk -> new Computer(disk, processor));
    }

    interface ComputerBuilder {
        ProcessorBuilder with(Processor processor);
    }

    interface ProcessorBuilder {
        Computer and(Disk disk);
    }

    public static void main(String[] args) {
        Computer.create(
                builder -> builder
                        .with(processor().core(2).speed(3).i386())
                        .and(Disk.disk().size(512).speed(7200).SATA())
        );
    }
}
