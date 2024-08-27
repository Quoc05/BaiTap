/*
 * @ (#) RTestRectangle.java    1.0   Aug 26, 2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.  
 */
package iuh.fit.se;
/*
* @description:
* @author: Quoc Nguyen
* @date:  Aug 26, 2024
* @version:   1.0
*/
import java.util.Scanner;

public class RTestRectangle {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rectangle rectangle = new Rectangle();

        System.out.print("Enter the length: ");
        double length = scanner.nextDouble();
        rectangle.setLength(length);

        System.out.print("Enter the width: ");
        double width = scanner.nextDouble();
        rectangle.setWidth(width);

        System.out.println("Area of the rectangle: " + rectangle.getArea());
        System.out.println("Perimeter of the rectangle: " + rectangle.getPerimeter());
    
        System.out.println(rectangle);

        scanner.close();
    }
}