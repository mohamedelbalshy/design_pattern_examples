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
    public Builder setDough(String dough);

    public Builder setSauce(String sauce);

    public Builder setTopping(String topping);

    public void build();
}

class PizzaBuilder implements Builder {

    Pizza pizza;

    public PizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public Builder setSauce(String sauce) {
        this.pizza.sauce = sauce;
        return this;
    }

    @Override
    public Builder setDough(String dough) {
        this.pizza.dough = dough;
        return this;
    }

    @Override
    public Builder setTopping(String topping) {
        this.pizza.topping = topping;
        return this;
    }

    @Override
    public void build() {
        this.pizza.print();
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Builder pizzaBuilder = new PizzaBuilder();
        pizzaBuilder.setSauce("Hot")
                .setDough("Thick")
                .setTopping("Meat")
                .build();

    }
}
