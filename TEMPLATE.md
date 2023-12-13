# Template
### Map <T, U>
<details>
    <summary>Example</summary>

    ```java
    public final class ConnectionPool {
    // This ConnectionPool class have only one instance
    // In the whole project.
    private static final ConnectionPool INSTANCE
            = new ConnectionPool();
    // Ensuring that none of other classes can't create
    // Instances directly.
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
