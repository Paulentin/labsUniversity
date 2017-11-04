package ua.nure.zabara.Practice4;

import java.io.*;
import java.util.Iterator;
import java.util.regex.*;


/**
 * Has iterator that looks through the string "iteratingString"
 * which is loaded from "fileName" through constructor
 * Iterator looks for match in iteratingString with regexp and returns string if it is a match
 *
 * */
class Parser implements Iterable<String> {

	public static void setIteratingString(String iteratingString) {
		Parser.iteratingString = iteratingString;
	}

	private static String iteratingString;
	private StringBuilder sb=new StringBuilder();


	public Parser(String fileName, String encoding) {


		File fl=new File(fileName);
		BufferedReader br=null;

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fl),encoding));
			String tmp;
			while((tmp=br.readLine())!=null){
				sb.append(tmp);
			}
			setIteratingString(sb.toString());
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

	}



	@Override
	public Iterator<String> iterator() {
		return new IteratorImpl() ;
	}


	private static class IteratorImpl implements Iterator<String> {

		private Pattern p=Pattern.compile("\\s*[^.!?]*[.!?]");
		private Matcher m=p.matcher(iteratingString);

		@Override
		public boolean hasNext() {
			return m.find();
		}

		@Override
		public String next() {
			System.out.println(m.group().trim());
			return m.group();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}