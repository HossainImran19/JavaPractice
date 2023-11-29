# Advance Java Practice
- **Overhead:** Amount of Time, Memory, Bandwidth or Resources required to do a specific task.
- Comaratively, runtime overheading of **Anonymous Inner Class** is sligthly higher than **Lamda Expression**.
- The Overheads of the Anonymous Inner class are
  1. Class loading
  2. Creation of object and allocation of memory.
  3. Object method call.
### Design Patterns
- **Singleton Pattern:** Ensures that a class has only one instance and provides a global point of access to it.
  <details>
    <summary>Example</summary>
  
    ```java
    public final class ConnectionPool {
    // This ConnectionPool class have only one instance
    // In the whole project.
    private static final ConnectionPool INSTANCE
            = new ConnectionPool();
    // Ensuring that none of other classes can't create
    // Instances of this.class
    private ConnectionPool(){}

    // Only method by which we can get the instance
    // that created for the whole project.
    public static ConnectionPool getInstance() {
        return INSTANCE;
    }

    public DataSource getDataSource() {
        var dbProb = ResourceBundle.getBundle("db");

        var config = new HikariConfig();
        config.setJdbcUrl(dbProb.getString("db.url"));
        config.setUsername(dbProb.getString("db.user"));
        config.setPassword(dbProb.getString("db.password"));
        config.setDriverClassName(dbProb.getString("db.driver"));
        var maxPoolSize
                = dbProb.getString("db.max.connections");
        config.setMaximumPoolSize(Integer.parseInt(maxPoolSize));

        return new HikariDataSource(config);
        }
    }
    ```
  </details>

- **Decorator Pattern:** Attaches additional responsibilities to an object dynamically, providing a flexible alternative to subclassing for extending functionality.
  <details>
    <summary>Example</summary>

    ```java
    public class DecoratorPattern {

    public static void main(String[] args) {
        // we can create different types of coffee
        // by combining constructors using the decorator pattern.
        var coffee = new VanillaAlmond(
                new SweetMilk(
                        new SaltedCaremelFudge(
                                new DarkCookieCrumb(
                                        new CoffeeBean()
                                )
                        )
                )
        );
        
        System.out.println(coffee.getIngredient());
    }
    @SafeVarargs
    public static Coffee getCoffeeWithExtras(Coffee coffee,
                                             Function<Coffee, Coffee>... ingregients) {
        Function<Coffee, Coffee> inital = kopi -> kopi;


        for (Function<Coffee, Coffee> ingredient : ingregients) {
            inital = inital.andThen(ingredient);
        }

        // we can write that in this way
        Function<Coffee, Coffee> reduced
                = Stream
                .of(ingregients)
                .reduce(
                        Function.identity(),
                        Function::andThen
                );


        return reduced.apply(coffee);
    }
    }

    @FunctionalInterface
    interface Coffee {
    // Method can add a property
    String getIngredient();
    }

    // Concrete class implementing Coffee
    class CoffeeBean implements Coffee {
    @Override
    public String getIngredient() {

        return "Coffee Bean";
    }
    }

    // Decorator class which have a reference of Coffee 
    abstract class CoffeeDecorator implements Coffee {
    private final Coffee coffee;

    // Initializing the coffee property.
    CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getIngredient() {
        return coffee.getIngredient();
    }
    }

    // Concrete Decorator classes
    class SaltedCaremelFudge extends CoffeeDecorator {
    SaltedCaremelFudge(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getIngredient() {
        return super.getIngredient() + " SaltedCaramelFudge";
    }
    }

    class SweetMilk extends CoffeeDecorator {
    SweetMilk(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getIngredient() {
        return super.getIngredient() + " SweetMilk";
    }
    }

    class DarkCookieCrumb extends CoffeeDecorator {
    DarkCookieCrumb(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getIngredient() {
        return super.getIngredient() + " DarkCookieCrumb";
    }
    }

    class VanillaAlmond extends CoffeeDecorator {
    VanillaAlmond(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getIngredient() {
          return super.getIngredient() + " VanilaAlmond";
      }
    }
    ```
  </details>
