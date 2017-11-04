package ua.nure.zabara.Practice6.part6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static final String ENCODING="Cp1251";
    WordContainer container;


    Part6(String s){
        String regEx="(-i\\s|--input\\s)(\\w+.txt\\s)(-t\\s|--task\\s)(frequency|duplicate|length)";
        Pattern p = Pattern.compile(regEx);
        Matcher m=p.matcher(s);
        while (m.find()) {
            tasker(readFile(m.group(2)),m.group(4));
        }
    }

    public String readFile(String path){

        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(path.trim()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(encoded);

    }

    public void tasker(String string,String task){

        container=new WordContainer();
        container.setString(string);
        switch (task){
            case "frequency":{
                container.frequency();
                break;
            }
            case "duplicate":{
                container.duplicate();
                break;
            }
            case "length":{
                container.maxLength();
            }
        }
    }

	public static void main(String[] args) {

        //Scanner sc=new Scanner(System.in);
        //new Part6(sc.nextLine());

    }
}


