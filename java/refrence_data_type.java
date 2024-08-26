package java;


import java.awt.Point;

public class refrence_data_type {
    public static void main(String[] args) {
        
        Point point1 = new Point(1,2);
        Point point2 = point1;
        System.out.println(point2);
        point1.x = 3;
        System.out.println(point2);
    }
}
