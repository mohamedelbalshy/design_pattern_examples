package Builder;

class Pizza {
    String topping;
    String sauce;
    String dough;

    public void print() {
        System.out.println("Pizza with Topping: " + this.topping + ", Sauce: " + this.sauce + ", Dough: " + this.dough);
    }
}

interface Builder {
    public Pizza setDough(String dough);

    public Pizza setSauce(String sauce);

    public Pizza setTopping(String topping);
}

class PizzaBuilder implements Builder {

    Pizza pizza;

    public PizzaBuilder() {

    }

    @Override
    public Pizza setSauce(String sauce) {
        this.pizza.sauce = sauce;
        return this.pizza;
    }

    @Override
    public Pizza setDough(String dough) {
        this.pizza.dough = dough;
        return this.pizza;
    }

    @Override
    public Pizza setTopping(String topping) {
        this.pizza.topping = topping;
        return this.pizza;
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Builder pizzaBuilder = new PizzaBuilder();
        pizzaBuilder.setSauce("Hot");
        pizzaBuilder.setDough("Thick");
        pizzaBuilder.setTopping("Meat");

    }
}
