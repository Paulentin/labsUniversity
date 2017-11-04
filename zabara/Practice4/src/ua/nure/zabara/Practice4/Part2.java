package ua.nure.zabara.Practice4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Part2 {



	private static List<Integer> readenData;

	private static final String RAW_DATA = "part2.txt";

	private static final String SORTED_DATA = "part2_sorted.txt";

	private static final int N = 10;

	private static final int MAX = 50;



	public static String read(String file){
		readenData=new ArrayList<>();
		StringBuilder sb=new StringBuilder();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"Cp1251"));
			String tmp = "";
			while ((tmp = br.readLine()) != null) {
				String[] s = tmp.split("\\s");
				for (String res : s) {
					readenData.add(Integer.parseInt(res));
					sb.append(res+" ");
				}
			}
			return sb.toString().trim();
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (br != null) {

				try {
					br.close();
				} catch (IOException e) {
					System.err.println(e+" err");
				}

			}
		}

		return "";
	}



	public static void write(String s,String fileName){
		File fl=new File(fileName);
		PrintWriter printWriter = null;

		if(!fl.exists()) {
            try {
                fl.createNewFile();
            } catch (Exception ex) {
                System.err.println("Faild to create file");
            }
		}

		try {
			printWriter=new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fl,false),"Cp1251")));
			printWriter.print(s);

		}catch (IOException e) {
			System.err.println(e+" writing in file");
		}finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}

	public static String generate(){
		Random r = new Random();
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append((r.nextInt()*MAX)+" ");
		}
		return sb.toString();
	}


	public static void sortAndwrite(){
        StringBuilder sb = new StringBuilder();

		if(!readenData.isEmpty()) {

            int n = readenData.size();
            int k;
            for (int m = n; m >= 0; m--) {
                for (int i = 0; i < n - 1; i++) {
                    k = i + 1;
                    if (readenData.get(i) > readenData.get(i + 1)) {
                        swap(i, k);
                    }
                }
            }


            for (Integer i : readenData) {
                sb.append(i + " ");
            }
        }
		write(sb.toString().trim(),SORTED_DATA);
	}
	private static void swap(int i,int k){
		int temp;
		temp=readenData.get(i);
		readenData.set(i,readenData.get(k));
		readenData.set(k,temp);

	}


	public static void main(String[] args) {

		write(generate(),RAW_DATA);
		read(RAW_DATA);
		System.out.println("input ==> "+ readenData);
		sortAndwrite();
		System.out.println("output ==> "+ readenData);


	}

}