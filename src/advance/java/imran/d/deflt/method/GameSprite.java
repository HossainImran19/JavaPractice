package advance.java.imran.d.deflt.method;

public interface GameSprite {
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);

    default void moveRight(int distance) {
        setX(getX() + distance);
    }

    // Default method only can use arguments.
    // But they can not read and write the states of interfaces.
    // Because interfaces have no states.
    default void movedLeft(int distance){
        setX(getX() - distance);
    }

    default void moveBottom(int distance) {
        setY(getY() - distance);
    }
}
