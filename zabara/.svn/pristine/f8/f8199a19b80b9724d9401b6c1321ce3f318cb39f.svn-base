package ua.nure.zabara.Practice3;

import java.util.LinkedHashSet;
import java.util.Set;


public class Part2 {

    static String convert(String input) {

        String buffer = input.replaceAll(",", "").replaceAll("\\r\\n|\\r|\\n|-|'", " ");
        String[] arr = buffer.split("(?U) ");
        StringBuilder sb = new StringBuilder();
        int maxLen = 0;
        int minLen = Integer.MAX_VALUE;

        for (String word : arr) {
            if ((maxLen == 0) || (maxLen < word.length())) {
                maxLen = word.length();
            }
            if (minLen > word.length()) {
                minLen = word.length();
            }
        }

        Set stringSet = new LinkedHashSet();

        sb.append("Min: ");
        for (String word : arr) {
            if (word.length() == minLen) {
                stringSet.add(word);
            }
        }

        sb.append(stringSet);
        stringSet.clear();

        sb.append(System.lineSeparator() + "Max: ");

        for (String word : arr) {
            if (word.length() == maxLen) {
                stringSet.add(word);
            }
        }
        sb.append(stringSet);
        return sb.toString().replace("[", "").replace("]", "");
    }

    public static void main(String[] args) {
        String input = Util.readFile("part2.txt");
        System.out.println(convert(input));
    }
}