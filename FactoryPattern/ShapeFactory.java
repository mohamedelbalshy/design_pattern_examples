package FactoryPattern;
enum ShapeType {
    CIRCLE,
    RECTANGLE,
    SQUARE
}

public class ShapeFactory {
    public Shape getShape(ShapeType shapeType){
        if(shapeType == ShapeType.CIRCLE){
            return new Circle();
        } else if(shapeType == ShapeType.RECTANGLE){
            return new Rectangle();
        }else if(shapeType == ShapeType.SQUARE){
            return new Square();
        }else{
            return null;
        }
    }
}
