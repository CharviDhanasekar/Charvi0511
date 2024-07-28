interface Coffee {
    double cost();
}

// Concrete component
class BasicCoffee implements Coffee {
    public double cost() {
        return 5.0;
    }
}

// Decorator interface
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public double cost() {
        return coffee.cost();
    }
}

// Concrete decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 1.0;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 0.5;
    }
}

class WhipDecorator extends CoffeeDecorator {
    public WhipDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 1.5;
    }
}

// Usage
public class Test5 {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        System.out.println("Basic Coffee: Rs." + coffee.cost());

        Coffee milkCoffee = new MilkDecorator(coffee);
        System.out.println("Milk Coffee: Rs." + milkCoffee.cost());

        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Milk and Sugar Coffee: Rs." + sugarMilkCoffee.cost());

        Coffee whipMilkSugarCoffee = new WhipDecorator(sugarMilkCoffee);
        System.out.println("Whip, Milk, and Sugar Coffee: Rs." + whipMilkSugarCoffee.cost());
    }
}