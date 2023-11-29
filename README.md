# Advance Java Practice
- **Overhead:** Amount of Time, Memory, Bandwidth or Resources required to do a specific task.
- Comaratively, runtime overheading of **Anonymous Inner Class** is sligthly higher than **Lamda Expression**.
- The Overheads of the Anonymous Inner class are
  1. Class loading
  2. Creation of object and allocation of memory.
  3. Object method call.
### Design Patterns
- **Singleton Pattern:** Ensures that a class has only one instance and provides a global point of access to it.
  - <summary>Example</summary>
  
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
