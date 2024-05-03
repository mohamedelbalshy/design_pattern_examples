package VisitorPattern;

interface Product {
    int accept(Visitor v);
}

interface Visitor {
    int visit(Screen p);

    int visit(Keyboard k);

}

class Screen implements Product {

    private int price;
    private String name;

    Screen(String name, int p) {
        this.price = p;
        this.name = name;
    }

    public int get_price() {
        return this.price;
    }

    public String get_name() {
        return this.name;
    }

    @Override
    public int accept(Visitor v) {
        return v.visit(this);
    }
}

class Keyboard implements Product {

    private int price;
    private String name;

    Keyboard(String name, int p) {
        this.price = p;
        this.name = name;
    }

    public int get_price() {
        return this.price;
    }

    public String get_name() {
        return this.name;
    }

    @Override
    public int accept(Visitor v) {
        return v.visit(this);
    }
}

class ProductVisitor implements Visitor {

    @Override
    public int visit(Screen s) {
        int price = s.get_price();
        if (price < 100) {
            return price - 5;
        } else {
            return price - (price / 10);
        }
    }

    @Override
    public int visit(Keyboard k) {
        int price = k.get_price();
        if (price < 100) {
            return price - 3;
        } else {
            return price - (price / 10);
        }
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        Product keyboard = new Keyboard("Dragon", 200);
        Product screen = new Screen("Samsung", 2000);
        System.out.println(keyboard.accept(new ProductVisitor()));
        System.out.println(screen.accept(new ProductVisitor()));

    }
}