package ua.nure.zabara.Practice4;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

	private static final String FILE_NAME = "part1.txt";

	private static final String ENCODING = "Cp1251";


	public static String read() {

	    BufferedReader br = null;
		String regEx="(?U)(\\w{4,})";
		File fl=new File(FILE_NAME);

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fl),ENCODING));
            Pattern p = Pattern.compile(regEx);

			String tmp ="";

			StringBuffer sb= new StringBuffer();

			Matcher m=null;

            while ((tmp = br.readLine()) != null) {
				m = p.matcher(tmp);

                while (m.find()) {
                	m.appendReplacement(sb,m.group().toUpperCase());
                }
                m.appendTail(sb);
                sb.append(System.lineSeparator());
            }
			System.out.println(sb.toString());
			return sb.toString().trim();

		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		}
		return regEx;
	}
	public static void main(String[] args) {
		read();
	}

}