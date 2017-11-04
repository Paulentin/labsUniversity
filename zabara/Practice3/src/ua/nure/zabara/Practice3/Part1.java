package ua.nure.zabara.Practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Part1 {
    private static String pattern = "(?U)([a-zа-яё]+)(;)([a-zа-яёА-ЯЁA-Z]+\\s[a-zа-яёА-ЯЁA-Z]+)(;)([a-zA-Z]+@[a-zA-Z]+.*)";

    static Matcher init(String input) {
        Pattern p = Pattern.compile(pattern);
        return p.matcher(input);
    }


    public static String convert1(String input) {
        Matcher m = init(input);


        while (m.find()) {
            System.out.println(m.group(1) + " ==> " + m.group(5));
        }
        return "";
    }

    public static String convert2(String input) {

        Matcher m = init(input);

        StringBuilder s = new StringBuilder();


        while (m.find()) {
            s.append(m.group(3) + " (email: " + m.group(5) + ")");
            s.append(System.lineSeparator());
        }
        return s.toString();
    }

    public static String convert3(String input) {

        Matcher m = init(input);

        StringBuilder smail = new StringBuilder();
        StringBuilder sgoogle = new StringBuilder();

        smail.append("mail.ru ==>");
        sgoogle.append("google.com ==>");

        while (m.find()) {
            if (m.group(5).contains("mail.ru")) {
                smail.append(" " + m.group(1) + ",");
            }
            if (m.group(5).contains("google.com")) {
                sgoogle.append(" " + m.group(1) + ",");
            }
        }
        smail.deleteCharAt(smail.lastIndexOf(","));
        smail.append(System.lineSeparator() + sgoogle);
        smail.deleteCharAt(smail.lastIndexOf(","));
        return smail.toString();
    }


    public static String convert4(String input) {

        Matcher m = init(input);

        StringBuilder sb = new StringBuilder();
        sb.append("Login;Name;Email;Password" + System.lineSeparator());
        while (m.find()) {
            sb.append(m.group(1)).append(m.group(2)).append(m.group(3)).append(m.group(4)).append(m.group(5))
                    .append(";" + (int) ((Math.random() * 9000) + 1000));

            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String input = Util.readFile("part1.txt");
        System.out.println(convert1(input));
        System.out.println(convert2(input));
        System.out.println(convert3(input));
        System.out.println();
        System.out.println(convert4(input));
    }
}