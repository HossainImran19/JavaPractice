package advance.java.imran.g.uses.of.lamda;

import java.util.function.Function;
import java.util.stream.Stream;

public class DecoratorPattern {

    public static void main(String[] args) {
        // Without the Lamda Expression
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

        // With the Lamda Expression
        var coffeeWithLamda = getCoffeeWithExtras(
                new CoffeeBean(),
                Coffee::SaltedCaremelFudge,
                Coffee::SweetMilk,
                Coffee::DarkCookieCrumb,
                Coffee::VanillaAlmond
        );

        System.out.println(coffeeWithLamda.getIngredient());
    }
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
    String getIngredient();

    static Coffee SaltedCaremelFudge(Coffee coffee) {
        return () -> coffee.getIngredient() + " SaltedCaramelFudge";
    }
    static Coffee SweetMilk(Coffee coffee) {
        return () -> coffee.getIngredient() + " SweetMilk";
    }

    static Coffee DarkCookieCrumb(Coffee coffee) {
        return () -> coffee.getIngredient() + " DarkCookieCrumb";
    }

    static Coffee VanillaAlmond(Coffee coffee) {
        return () -> coffee.getIngredient() + " VanillaAlmond";
    }

}

class CoffeeBean implements Coffee {
    @Override
    public String getIngredient() {

        return "Coffee Bean";
    }
}

// Decorator class
abstract class CoffeeDecorator implements Coffee {
    private final Coffee coffee;
    CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    @Override
    public String getIngredient() {
        return coffee.getIngredient();
    }
}

// Concrete Decorator class
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
