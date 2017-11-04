package ua.nure.zabara.Practice6.part7;

import java.util.*;

public class Part7 {





	public static void main(String[] args) {

        Range r = new Range(true);
        while(r.it.hasNext())
            System.out.println(r.it.next());

	}

}
class Range implements Iterable{

	List list = new ArrayList();

	int n;
	int m;
	private boolean reverse=false;
    Iterator it;


	Range(boolean reverse){
	    list.addAll(Arrays.asList(0,1,12,3,4,5,6,7));
		this.reverse=reverse;
        it=list.iterator();
	}


	@Override
	public Iterator iterator() {
	    if(this.reverse==false){

            return new IteratorImpl();
        }else {
	        return new ReverseIteratorImpl();
        }
	}

	private class IteratorImpl implements Iterator<Object> {
		int cursor=n;
		int lastReturn;

		public boolean hasNext() {
			return cursor != m;
		}

		@Override
		public Object next() {
			int temporaryCursor=this.cursor;
			if(temporaryCursor>=m){
				throw new NoSuchElementException();
			}
			this.cursor=temporaryCursor+1;
			return list.get(lastReturn = temporaryCursor);
		}

		@Override
		public void remove() {

		}
	}

    private class ReverseIteratorImpl implements Iterator<Object> {
        int cursor=m;
        int lastReturn;

        public boolean hasNext() {
            return cursor != n;
        }

        @Override
        public Object next() {
            int temporaryCursor=this.cursor;
            if(temporaryCursor<=n){
                throw new NoSuchElementException();
            }
            this.cursor=temporaryCursor+1;
            return list.get(lastReturn = temporaryCursor);
        }

		@Override
		public void remove() {

		}
	}




}


/*

Задание 7
		Написать класс Range , который бы представлял собой промежуток чисел [n, m], где n < m. Класс должен
		реализовывать интерфейс Iterable. Итератор реализовать таким образом, чтобы он проходил он начала до
		конца промежутка. В конструктор передавать дополнительный параметр reverse .Пример.
		Промежуток - [3, 10]
		reverse = true - итератор проходит от начала до конца промежутка 3, 4, 5, 6, 7, 8, 9, 10
		reverse = false - итератор проходит от конца до начала промежутка (т.е. в обратном порядке) 10, 9, 8, 7, 6, 5,
		4, 3
*/