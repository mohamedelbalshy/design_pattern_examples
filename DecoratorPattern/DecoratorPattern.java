package DecoratorPattern;

abstract class Pizza {

    abstract void order();
}

class ChickenPizza extends Pizza {

    @Override
    void order() {
        System.out.print("Chicken Pizza ");
    }
}

class MeatPizza extends Pizza {
    @Override
    void order() {
        System.out.print("Meat Pizza ");
    }
}

class Addon extends Pizza {
    Pizza pizza;

    Addon(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    void order() {
        pizza.order();
    }
}

class Mushroom extends Addon {

    Mushroom(Pizza pizza) {
        super(pizza);
    }

    @Override
    void order() {
        this.pizza.order();
        System.out.print(" with added Mushroom");
    }
}

class Cheese extends Addon {

    Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    void order() {
        this.pizza.order();

        System.out.print(" and with added Cheese");
    }
}

public class DecoratorPattern {

    public static void main(String[] args) {

        Pizza chickenPizza = new ChickenPizza();

        Addon mushroomPizza = new Mushroom(chickenPizza);

        Addon cheeseMushroomPizza = new Cheese(mushroomPizza);
        cheeseMushroomPizza.order();
        System.out.println("");
    }
}