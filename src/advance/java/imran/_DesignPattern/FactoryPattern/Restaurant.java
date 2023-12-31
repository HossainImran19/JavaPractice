package advance.java.imran._DesignPattern.FactoryPattern;

// Creator interface/abstract class
public abstract class Restaurant {
    public Burger orderBurger() {
        Burger burger = createBurger();
//        burger.prepare();
        return burger;
    }

    // Product Creator factory.
    public abstract Burger createBurger();
}
