package lab2;

import lab3.MyListImpl;

import java.util.*;

public class Orchestra {

    public static void main(String[] args) {

        Piano p=new Piano();
        MyListImpl list = new MyListImpl();
        list.add(p);
        list.add(new Trumpet());
        list.add(new Drum());
        list.add(new Guitar());

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Instrument i=(Instrument)iterator.next();
            i.play();
        }

        System.out.println(list.toString());
    }
    public static MyListImpl getOrchestra(){
        Piano p=new Piano();
        MyListImpl list = new MyListImpl();
        list.add(p);
        list.add(new Trumpet());
        list.add(new Drum());
        list.add(new Guitar());

        return list;
    }

}
