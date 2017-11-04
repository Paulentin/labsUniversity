package ua.nure.zabara.Practice6.part1;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {


		//to launch code yoy have to uncommentScanner sc=new Scanner(System.in);
		WordContainer container=new WordContainer();

		//to launch code yoy have to uncomment container.setString(sc.nextLine());
		Cmp cmp=new Cmp();
        Collections.sort(container.lWord,cmp);

        System.out.println(container.toString());

	}

}

class Cmp implements Comparator{

    @Override
    public int compare(Object o, Object t1) {
        Word w=(Word)o;
        Word r1=(Word)t1;

         return w.getFrequency()-r1.getFrequency()==0?
                    w.getWord().length()-r1.getWord().length()
                        :w.getFrequency()-r1.getFrequency();
    }
}