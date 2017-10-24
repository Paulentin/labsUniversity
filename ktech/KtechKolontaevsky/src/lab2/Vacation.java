package lab2;


import lab3.MyListImpl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Crimea extends BySea{
    @Override
    void haveSunBath() {
        System.out.println("Having sunbath in Crimea");
    }
}
class LasVegas extends InMegapolis{
    @Override
    void getDrunk() {
        System.out.println("Get drunk and play in casino");
    }

    @Override
    void haveHangout() {
        System.out.println("Have headache next morning");
    }
}
class Alps extends InMountains{
    @Override
    void climbTheMountain() {
        System.out.println("Climb Alpean mountain");
    }

    @Override
    void goSkiing() {
        System.out.println("Ski down of it");
    }
}

public class Vacation {public static void main(String[] args) {
      /*List<CompanyResort> ins = new LinkedList<>();

        ins.add(new Crimea());
        ins.add(new LasVegas());
        ins.add(new Alps());

        for (CompanyResort in : ins) {
            in.bookResort();
        }
*/

    Alps alps=new Alps();
    ////////////////////////
    //checking comparator
    CompanyResort listCheckCompare []= new CompanyResort[4];
    listCheckCompare[0]=alps;
    listCheckCompare[1]=new Crimea();
    listCheckCompare[2]=new LasVegas();
    listCheckCompare[3]=new Alps();

    listCheckCompare[0].price=222;
    listCheckCompare[1].price=3;
    listCheckCompare[2].price=250;
    listCheckCompare[3].price=220;


    Arrays.sort(listCheckCompare,new CmpPrice());
    System.out.println(Arrays.toString(listCheckCompare));



    //Checking created list from lab3
    MyListImpl list = new MyListImpl();
    list.add(alps);
    list.add(new LasVegas());
    list.add(new Crimea());
    list.add(new Alps());


    //checking iterator created in lab3
    Iterator iterator=list.iterator();
    while (iterator.hasNext()){
        CompanyResort i=(CompanyResort) iterator.next();
        i.bookResort();
    }
}


    // creating list of resorts
    public static MyListImpl getResorts(){
        Alps p=new Alps();
        MyListImpl list = new MyListImpl();
        list.add(p);
        list.add(new LasVegas());
        list.add(new Crimea());
        list.add(new Alps());

        return list;
    }
}
