package advance.java.imran.g.uses.of.lamda;

import java.util.function.Consumer;

public class BuilderPattern {
    public static void main(String[] args) {

    }
}

class Computer {
    private final Disk disk;
    private final Processor processor;

    public Computer(Disk disk, Processor processor) {
        this.disk = disk;
        this.processor = processor;
    }

    public static void create(Consumer<ComputerBuilder> builder) {
//        builder.accept(processor -> disk -> new Computer(disk, processor));
    }

    interface ComputerBuilder {
        Processor.ProcessorBuilder with(Processor processor);
    }

    interface ProcessorBuilder {
        Computer and(Disk disk);
    }

//    public static void main(String[] args) {
//        Computer.create(builder -> builder
//                .with(processor().core(2).speed(3).i386())
//                .and(disk().size(512).speed(7200).sata())
//        );
//    }

    public Disk getDisk() {
        return disk;
    }

    public Processor getProcessor() {
        return processor;
    }

    // This inner class is configuring
    // the properties of the containing class.
//    public static final class ComputerBuilder {
//        private Disk disk;
//        private Processor processor;
//
//        private ComputerBuilder() {
//
//        }
//
//        public static ComputerBuilder aComputer() {
//            return new ComputerBuilder();
//        }
//
//        public ComputerBuilder withDisk(Disk disk) {
//            this.disk = disk;
//            return this;
//        }
//
//        public ComputerBuilder withProcessor(Processor processor) {
//            this.processor = processor;
//            return this;
//        }
//
//        public Computer build() {
//            return new Computer(disk, processor);
//        }
//    }
}

class Disk {
    enum Type {
        SATA, PATA, SCSI, SAS, M2, FC
    }

    private int size;
    private int speed;
    private Type type;

    public Disk(){

    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Disk(int size, int speed, Type type) {
        this.size = size;
        this.speed = speed;
        this.type = type;
    }

    public static DiskBuilder disk() {
        return size1 -> speed1 -> type1 -> new Disk(size1, speed1, type1);
    }

    interface DiskBuilder {
        SpeedBuilder size(int size);
    }

    interface SpeedBuilder {
        TypeBuilder speed(int speed);
    }
    interface TypeBuilder {
        Disk type(Type type);

        default Disk sata() {
            return type(Type.SATA);
        }
    }
}

class Processor {
    enum Type {
        i386, x64, x86_64
    }

    private final int cores;
    private final int speed;
    private final Type type;

    public int getCores() {
        return cores;
    }

    public int getSpeed() {
        return speed;
    }

    public Type getType() {
        return type;
    }

    public Processor(int cores, int speed, Type type) {
        this.cores = cores;
        this.speed = speed;
        this.type = type;
    }

    interface ProcessorBuilder {
        SpeedBuilder core(int core);
    }
    interface SpeedBuilder {
        TypeBuilder speed(int speed);
    }
    interface TypeBuilder {
        Processor type(Type type);

        default Processor i386() {
            return type(Type.i386);
        }
    }

    public static ProcessorBuilder processor() {
        return core -> speed1 -> type -> new Processor(core, speed1, type);
    }

    public static void main(String[] args) {
        Processor.processor().core(2).speed(3).i386();
    }
}


