package lab2;

import lab3.MyListImpl;

import java.util.*;

class Guitar extends Stringed {
    @Override
    void twitchStrings() {
        System.out.println("Guitar twitching");
    }


}
class Trumpet extends Wind{

    @Override
    void blow() {
        System.out.println("Trumpet blowing");
    }
}
class Drum extends Percussion{

    @Override
    void beat() {
        System.out.println("Drum beat");
    }
}
class Piano extends Keyboard{

    @Override
    void pressKeys() {
        System.out.println("Piano key pressing");
    }
}

public class Orchestra {

    public static void main(String[] args) {
     /* List<Instrument> ins = new LinkedList<>();

        ins.add(new Piano());
        ins.add(new Trumpet());
        ins.add(new Drum());
        ins.add(new Guitar());

        for (Instrument in : ins) {
            in.play();
        }
*/


        Piano p=new Piano();
        /*

        Instrument listCheckCompare []= new Instrument[5];
        listCheckCompare[0]=p;
        listCheckCompare[1]=new Trumpet();
        listCheckCompare[2]=new Drum();
        listCheckCompare[3]=new Guitar();
        listCheckCompare[4]=new Drum();

        listCheckCompare[0].price=222;
        listCheckCompare[1].price=300;
        listCheckCompare[2].price=250;
        listCheckCompare[3].price=220;
        listCheckCompare[4].price=220;


        int compare=new CmpInstruments().compare(listCheckCompare[0],listCheckCompare[2]);
        System.out.println(compare);
        Arrays.sort(listCheckCompare,new CmpInstruments());

        */


        MyListImpl list = new MyListImpl();
        list.add(p);
        list.add(new Trumpet());
        list.add(new Drum());
        list.add(new Guitar());




        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            Instrument i=(Instrument)iterator.next();
            i.play();
        }
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
