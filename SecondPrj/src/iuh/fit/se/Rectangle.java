/*
 * @ (#) Rectangle.java    1.0   Aug 26, 2024
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
public class Rectangle {
	private double length;
    private double width;

    public Rectangle() {
        this.length = 0.0;
        this.width = 0.0;
    }

    public Rectangle(double length, double width) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length and width must be greater than 0");
        }
        this.length = length;
        this.width = width;
    }
    
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double newVal) {
        if (newVal < 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        this.length = newVal;
    }

    public void setWidth(double newVal) {
        if (newVal < 0) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        this.width = newVal;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    public String toString() {
        return "Rectangle[length=" + length + ", width=" + width + "]";
    }
}

