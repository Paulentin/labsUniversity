package ua.nure.zabara.Practice4;


import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

	private static final String REG_CHAR="(?U)(\\b\\p{Alpha}\\s)";
	private static final String REG_STRING="(?U)\\p{L}{1,}[\\D]\\s";
	private static final String REG_INT="\\s\\d*\\s";
	private static final String REG_DOUBLE="[0-9]*\\.[0-9]*";



	static String checker(String regExp){
        StringBuilder sb = new StringBuilder();
        BufferedReader br=null;


        try {
            br = new BufferedReader(new InputStreamReader(
									 new FileInputStream("part3.txt"),"Cp1251"));

            Pattern p =Pattern.compile(regExp);
            Matcher m = null;
            String tmp;

            while ((tmp = br.readLine()) != null) {
                m = p.matcher(tmp);
                while (m.find()) {
                       sb.append(m.group().trim()+" ");
                }
            }

            System.out.println(sb.toString().trim());
        return sb.toString().trim();
        } catch (IOException e) {
            System.err.println(e);
        }finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }



    return "";
    }


    public static String getOutput(String s){
	    switch (s){
            case "int":
                return checker(REG_INT);
            case "String":
                return checker(REG_STRING);
            case "double":
                return checker(REG_DOUBLE);
            case "char":
                return checker(REG_CHAR);

	    }
    return "";
    }

	public static void main(String[] args) {

        Scanner sc= new Scanner(System.in,"Cp1251");

        while(sc.hasNext()){
            String s=sc.next();
            if ("stop".equalsIgnoreCase(s)){
                sc.close();
                break;
            }else{
                getOutput(s);
            }
        }


	}

}