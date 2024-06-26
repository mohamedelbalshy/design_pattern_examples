package FactoryPattern;
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape(ShapeType.CIRCLE);
        circle.draw();

        Shape rectangle = shapeFactory.getShape(ShapeType.RECTANGLE);
        rectangle.draw();
    }
}

