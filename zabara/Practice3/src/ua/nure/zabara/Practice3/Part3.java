package ua.nure.zabara.Practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static String convert(String input) {
        Pattern p = Pattern.compile("(?U)\\w+.\\s|\\w+\\s|\\w+");
        Matcher m = p.matcher(input);
        StringBuilder sb = new StringBuilder();

        while (m.find()) {
            if (m.group().length() > 3) {
                sb.append(Character.toUpperCase(m.group().charAt(0)))
                        .append(m.group().substring(1));
            } else {
                sb.append(m.group());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = Util.readFile("part3.txt");
        System.out.println(convert(input));
    }
}