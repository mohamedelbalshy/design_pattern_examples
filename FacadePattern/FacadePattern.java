package FacadePattern;

class DishWasher {

    static public void wash() {
        System.out.println("Wash the dishes!");
    }
}

class CoffeeMachine {

    static public void makeCoffee() {
        System.out.println("Make Coffee!");
    }
}

class Microwave {
    static public void meltFrozenFood() {
        System.out.println("Melt frozen food!");
    }
}

class Cooker {

    static public void cook() {
        System.out.println("Cook the food!");
    }
}

class Kitchen {

    public void morningRoutine() {
        CoffeeMachine.makeCoffee();
        Microwave.meltFrozenFood();
        Cooker.cook();
        DishWasher.wash();

    }
}

public class FacadePattern {

    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        kitchen.morningRoutine();
    }
}
