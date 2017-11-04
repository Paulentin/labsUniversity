package ua.nure.zabara.Practice6.part2;


import java.util.ArrayList;
import java.util.List;

public class Part2 {

    public static void operate(List l, int k){
        int pos=0;
        int arrsize=l.size();
        while (arrsize>1){
            pos+=k;
            if(pos>arrsize){
                while(pos>arrsize){
                    pos=pos-arrsize;
                }


            }
            System.out.println(pos);
            l.remove(pos);
            arrsize--;
        }
    }


	public static void main(String[] args) {
        List<Man> m =new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            m.add(new Man());
        }
        operate(m,7);
    }

}
class Man {

}