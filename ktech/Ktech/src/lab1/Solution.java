package lab1;

public class Solution {
    public static void main(String[] args) {
        Triangle t = new Triangle();
        new Dot();
        t.getMinDistanceToCentre();
    }
}

class Triangle {
    double x1, x2, x3;
    double y1, y2, y3;
    double firstMidX;
    double firstMidY;
    double secondMidX;
    double secondMidY;
    double thirdMidX;
    double thirdMidY;
    Dot dotInside;

    Triangle(double x1, double y1, double x2, double y2, double x3, double y3, double insideTrX, double insideTrY) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        dotInside = new Dot(insideTrX, insideTrY);
    }

    Triangle() {
        this(1, 1, 5, 1, 3, 5, 1.5, 1.6);
    }

    public void getMinDistanceToCentre() {
        countMidOfSides();
        double[] closestSideToDot = lengthsToDot();

        System.out.println("length:" + closestSideToDot[0]);
        System.out.println("coordintes of mid dot on side(" + closestSideToDot[1] + ";" + closestSideToDot[2] + ")");
        System.out.println("dotInside(" + dotInside.x + ";" + dotInside.y + ")");
    }

    private void countMidOfSides() {
        firstMidX = (x1 + x2) / 2;
        firstMidY = (y1 + y2) / 2;
        secondMidX = (x2 + x3) / 2;
        secondMidY = (y2 + y3) / 2;
        thirdMidX = (x3 + x1) / 2;
        thirdMidY = (y3 + y1) / 2;
    }

    private double[] lengthsToDot() {
        double lengthFirst = Math.sqrt(Math.pow(firstMidY - dotInside.y, 2) + Math.pow(firstMidX - dotInside.x, 2));
        double lengthSecond = Math.sqrt(Math.pow(secondMidY - dotInside.y, 2) + Math.pow(secondMidX - dotInside.x, 2));
        double lengthThird = Math.sqrt(Math.pow(thirdMidY - dotInside.y, 2) + Math.pow(thirdMidX - dotInside.x, 2));

        if (lengthFirst < lengthSecond && lengthFirst < lengthThird) {
            System.out.println("1st");
            return new double[]{lengthFirst, firstMidX, firstMidY};
        }
        if (lengthSecond < lengthFirst && lengthSecond < lengthThird) {
            System.out.println("2nd");
            return new double[]{lengthSecond, secondMidX, secondMidY};
        }
        if (lengthThird < lengthFirst && lengthThird < lengthSecond) {
            System.out.println("3rd");
            return new double[]{lengthThird, thirdMidX, thirdMidY};
        }
        return null;
    }
}

class Dot {
    final double x;
    final double y;

    Dot() {
        this(3, 2);
    }

    Dot(double x, double y) {

        this.x = x;
        this.y = y;
    }
}