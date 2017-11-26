package ua.nure.zabara.Practice3;

import java.util.LinkedHashMap;
import java.util.Map;


public class Part5 {
    private static Map<Integer, String> numerals = new LinkedHashMap();

    static {
        numerals.put(Integer.valueOf(1000), "M");
        numerals.put(Integer.valueOf(900), "CM");
        numerals.put(Integer.valueOf(500), "D");
        numerals.put(Integer.valueOf(400), "CD");
        numerals.put(Integer.valueOf(100), "C");
        numerals.put(Integer.valueOf(90), "XC");
        numerals.put(Integer.valueOf(50), "L");
        numerals.put(Integer.valueOf(40), "XL");
        numerals.put(Integer.valueOf(10), "X");
        numerals.put(Integer.valueOf(9), "IX");
        numerals.put(Integer.valueOf(5), "V");
        numerals.put(Integer.valueOf(4), "IV");
        numerals.put(Integer.valueOf(3), "III");
        numerals.put(Integer.valueOf(2), "II");
        numerals.put(Integer.valueOf(1), "I");
    }

    public static String decimal2Roman(int x) {
        StringBuilder sb = new StringBuilder();
        int value = x;
        while (value != 0) {
            for (Integer key : numerals.keySet()) {
                if (value - key.intValue() >= 0) {
                    value -= key.intValue();
                    sb.append(numerals.get(key));
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static final int roman2Decimal(String roman) {
        int start = 0;
        int value = 0;
        for (Integer i : numerals.keySet()) {
            while (roman.startsWith(numerals.get(i), start)) {
                value += i.intValue();
                start += (numerals.get(i)).length();
            }
        }
        return start == roman.length() ? value : -1;
    }

    public static void main(String[] args) {
        System.out.println(decimal2Roman(57566));

    }

}