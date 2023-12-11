package advance.java.imran.GUsesOfLamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FluentProgramming {
    public static void main(String[] args) {
//        Sandwich sandwich = new Sandwich();
//        sandwich.setBread("White");
//        sandwich.setCheese("Cheddar");
//        sandwich.setMeat("Beef");
//        sandwich.addVegetables("Tomato");
//        sandwich.addVegetables("Cucumber");
//        sandwich.make();

        // We can write this to reduce the redundant word 'sandwich'.
        // This is called Method Chaining or Train Wreck.
//        Sandwich sandwichNoRepeat
//                = new Sandwich()
//                        .setBread("White")
//                        .setCheese("Cheddar")
//                        .setMeat("Beef")
//                        .addVegetables("Cucumber")
//                        .addVegetables("Tomato")
//                        .make();

        // To make it more Fluent, we can make its design as below
        // using Fluent Programming.
        // This is an example of Fluent Programming
        // where no repetition of multiple words,
        // didn't need to make instance using new key word
        Sandwich.make(
                sandwich -> sandwich
                        .setBread("White")
                        .setCheese("Cheddar")
                        .setMeat("Beef")
                        .addVegetables("Tomato")
                        .addVegetables("Cucumber")
                );

        ConfigurationManager confManager
                = ConfigurationManager.make(
                        configurationManager -> configurationManager
                                .setUrl("production.mydatabase.com")
                                .setUsername("imran")
                                .setPassword("1234")
                                .addRole("admin")
                                .addRole("Developer")
                );
    }
}

class Sandwich {
    private String bread;
    private String meat;
    private String cheese;
    private List<String> vegetables = new ArrayList<>();

    private Sandwich() {}

    public Sandwich setBread(String bread) {
        this.bread = bread;
        return this;
    }

    public Sandwich setMeat(String meat) {
        this.meat = meat;
        return this;
    }

    public Sandwich setCheese(String cheese) {
        this.cheese = cheese;
        return this;
    }

    public Sandwich addVegetables(String vegetable) {
        this.vegetables.add(vegetable);
        return this;
    }

    public static Sandwich make(Consumer<Sandwich> sandwichConsumer) {
        System.out.println("Making a sandwich");
        Sandwich sandwich = new Sandwich();
        sandwichConsumer.accept(sandwich);
        return sandwich;
    }
}

class ConfigurationManager {
    private String url;
    private String username;
    private String password;
    private List<String> roleList = new ArrayList<>();

    private ConfigurationManager() {

    }

    public ConfigurationManager setUrl(String url) {
        this.url = url;
        return this;
    }

    public ConfigurationManager setUsername(String username) {
        this.username = username;
        return this;
    }

    public ConfigurationManager setPassword(String password) {
        this.password = password;
        return this;
    }

    public ConfigurationManager addRole(String role) {
        this.roleList.add(role);
        return this;
    }

    public static ConfigurationManager make(Consumer<ConfigurationManager> consumer) {
        System.out.println("Making a configurationManager");
        ConfigurationManager confManager = new ConfigurationManager();

        consumer.accept(confManager);
        return confManager;
    }
}
