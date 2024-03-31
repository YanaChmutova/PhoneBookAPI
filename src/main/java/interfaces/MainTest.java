package interfaces;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5));
        shapes.add(new Rectangle(2,4));
        for (Shape shape : shapes){
            System.out.println("Area : "+ shape.calculateArea());
        }


    }
}