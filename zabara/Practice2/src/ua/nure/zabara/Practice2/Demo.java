package ua.nure.zabara.Practice2;

/**
 * @author zabara
 */
public class Demo {

    public static void main(String[] args) {
        MyListImpl con=new MyListImpl();
        con.add(1);
        con.add(2);
        con.add(3);
        con.add(4);

        ListIterator listIterator=con.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
        System.out.println();
    }
}
