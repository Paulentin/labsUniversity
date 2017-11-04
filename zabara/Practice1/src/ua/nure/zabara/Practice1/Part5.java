package ua.nure.zabara.Practice1;

import java.util.ArrayList;

/**
 * Created by dobro on 6/27/17.
 */
public class Part5 {

    int [] arr=new int[]{1,2,3,4,5};
    int [] arr1={1,2,4,5};


    private static String dictionary = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static int str2int(String number) {

        int result = 0;
        int index;
        double pow;
        for (int i = 0; i < number.length(); i++) {

            index = dictionary.indexOf(number.charAt(i)) + 1;
            pow = Math.pow(26, number.length() - i - 1);
            result += index * pow;
        }
        return result;
    }



    public static String int2str(int number) {
        ArrayList<Integer> codesOfChars = new ArrayList<Integer>();
        int local=number;
        //Calculating indexes of chars
        while (local > 26) {
            if (local % 26 == 0) {
                codesOfChars.add(0,26);
                local = (local / 26)-1;
            } else {
                codesOfChars.add(0, local % 26);
                local = local / 26;
            }
        }
        codesOfChars.add(0, local);

        //Transforming indexes to chars and concatenation them
        StringBuilder builder = new StringBuilder();
        for (int el : codesOfChars) {
            builder.append(dictionary.charAt(el - 1));
        }

        return builder.toString();
    }


    public static String rightColumn(String number) {
        return int2str(str2int(number) + 1);
    }


    public static void main(String[] args) {
        final String arrow=" ==> ";
        System.out.println("A" + arrow + str2int("A") + arrow + int2str(1));
        System.out.println("B"+ arrow + str2int("B") + arrow + int2str(2));
        System.out.println("Z"+ arrow + str2int("Z") + arrow + int2str(26));
        System.out.println("AA"+ arrow + str2int("AA") + arrow + int2str(27));
        System.out.println("AZ"+ arrow + str2int("AZ") + arrow + int2str(52));
        System.out.println("BA"+ arrow + str2int("BA") + arrow + int2str(53));
        System.out.println("ZZ"+ arrow + str2int("ZZ") + arrow + int2str(702));
        System.out.println("AAA"+ arrow + str2int("AAA") + arrow + int2str(703));
    }
}