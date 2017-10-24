package lab1;

public class Solution{




    public static void main(String[] args) {
        new Triangle();
        new Dot();


    }
}

class Triangle{
    int x1;
    int y1;

    int x2;
    int y2;

    int x3;
    int y3;

    Triangle(int x1, int y1, int x2, int y2, int x3, int y3){

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    Triangle(){
        this(1,1,2,2,3,3);
    }


}
class Dot{
    private final int x;
    private final int y;

    Dot(int x, int y){

        this.x = x;
        this.y = y;
    }
    Dot(){
        this(3,2);
    }
}