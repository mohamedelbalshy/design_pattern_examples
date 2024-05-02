package BridgePattern;

interface Color {
    void color();
}

class Red implements Color {
    @Override
    public void color() {
        System.out.print("Red");
    }
}

class Blue implements Color {
    @Override
    public void color() {
        System.out.print("Blue");
    }
}

abstract class Shape {
    protected Color color;

    Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

class Rectangle extends Shape {

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Draw ");
        this.color.color();
        System.out.println(" Rectangle");
    }
}

class Circle extends Shape {

    Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Draw ");
        this.color.color();
        System.out.println(" Circle");

    }
}

public class BridgePattern {
    public static void main(String[] args) {

        Color red = new Red();
        Shape r = new Rectangle(red);
        r.draw();

        Color blue = new Blue();
        r = new Rectangle(blue);
        r.draw();

        Shape c = new Circle(blue);
        c.draw();

        c = new Circle(red);
        c.draw();
    }
}
