package advance.java.imran.g.uses.of.lamda.e.builder;

public class Disk {
    public enum Type {
        SATA, PATA
    }

    private final int size;
    private final int speed;
    private final Type type;

    public Disk(int size, int speed, Type type) {
        this.size = size;
        this.speed = speed;
        this.type = type;
    }


    public static DiskBuilder disk() {
        return size -> speed -> type -> new Disk(size, speed, type);
    }

    public interface DiskBuilder {
        SpeedBuilder size(int size);
    }

    public interface SpeedBuilder {
        TypeBuilder speed(int speed);
    }

    public interface TypeBuilder {
        Disk type(Type type);

        default Disk SATA() {
            return type(Type.SATA);
        }
    }
}
