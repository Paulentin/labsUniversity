package lab1;

public class Solution {
    public static void main(String[] args) {
        Triangle t= new Triangle();
        new Dot();
        t.getMinDistanceToCentre();
    }
}

class Triangle {
    double x1;
    double y1;

    double x2;
    double y2;

    double x3;
    double y3;

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
        this(1, 1, 2, 2, 3, 3, 1.5, 1.6);
    }

    public void getMinDistanceToCentre() {
        countMidOfSides();
        double [] closestSideToDot = lengthsToDot();

        System.out.println("length:" + closestSideToDot[0]);
        System.out.println("dot:" + closestSideToDot[1]+";"+closestSideToDot[2]);
        System.out.println("dotInside:" + dotInside.x+";"+dotInside.y);
    }

    private double[] lengthsToDot(){
        double lengthFirst = Math.sqrt(Math.pow(firstMidY-dotInside.y,2)+Math.pow(firstMidX-dotInside.x,2));
        double lengthSecond = Math.sqrt(Math.pow(secondMidY-dotInside.y,2)+Math.pow(secondMidX-dotInside.x,2));
        double lengthThird = Math.sqrt(Math.pow(thirdMidY-dotInside.y,2)+Math.pow(thirdMidX-dotInside.x,2));

        if(lengthFirst<lengthSecond && lengthFirst < lengthThird){
            return new double[]{lengthFirst,firstMidX,firstMidY};
        }
        if(lengthSecond<lengthFirst && lengthSecond < lengthThird){
            return new double[]{lengthSecond,secondMidX,secondMidY};
        }
        if(lengthThird<lengthFirst && lengthThird < lengthSecond){
            return new double[]{lengthThird,thirdMidX,thirdMidY};
        }
        return null;
    }

    private void countMidOfSides() {
        firstMidX = (x1 + x2) / 2;
        firstMidY = (y1 + y2) / 2;
        secondMidX = (x2 + x3) / 2;
        secondMidY = (y2 + y3) / 2;

        thirdMidX = (x3 + x1) / 2;
        thirdMidY = (y3 + y1) / 2;
    }
}

class Dot {
    final double x;
    final double y;

    Dot(double x, double y) {

        this.x = x;
        this.y = y;
    }

    Dot() {
        this(3, 2);
    }
}