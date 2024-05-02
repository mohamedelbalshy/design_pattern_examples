package Strategy;

/**
 * Strategy
 */
interface Strategy {
    public int execute(int x, int y);
}

class Add implements Strategy {

    @Override
    public int execute(int x, int y) {
        return x + y;
    }
}

class Multiplication implements Strategy {
    @Override
    public int execute(int x, int y) {
        return x * y;
    }
}

class Context implements Strategy {
    Strategy strategy;

    public Context(Strategy s) {
        this.strategy = s;
    }

    @Override
    public int execute(int x, int y) {
        return this.strategy.execute(x, y);
    }

}

public class StrategyPatternDemo {

    public static void main(String[] args) {

        Strategy multiplicationStrategy = new Multiplication();
        Strategy addStrategy = new Add();
        Context context = new Context(multiplicationStrategy);
        System.out.println(context.execute(5, 4));
        context = new Context(addStrategy);
        System.out.println(context.execute(5, 4));
    }
}
