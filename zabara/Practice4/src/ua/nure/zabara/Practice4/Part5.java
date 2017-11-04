package ua.nure.zabara.Practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Part5 {

	private static final String BASE_NAME = "resources";

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in,"Cp1251").useDelimiter("\\s");
        String[] array= new String[2];
        scanner:
        while (sc.hasNext()) {
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.next();
                if ("stop".equalsIgnoreCase(array[i])){
                    sc.close();
                    break scanner;
                }
            }
            getlocale(array);
        }
	}
	static void getlocale(String[] s){
        Locale l = new Locale(s[1]);
        ResourceBundle r = ResourceBundle.getBundle(BASE_NAME,l);
        String value =r.getString(s[0]);
        System.out.println(value);
    }

}