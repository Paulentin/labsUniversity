package ua.nure.zabara.Practice2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyListImpl implements MyList, ListIterable {

    Object[] array = new Object[10];
    Object[] buffer;
    int size = 0;

    public void add(Object e) {
        if (size != this.array.length - 1) {
            array[size] = e;
            size++;
        } else {
            // после первого вхождения увеличивает массив при каждой вставке
            buffer = new Object[array.length];
            System.arraycopy(array, 0, buffer, 0, array.length);
            array = new Object[this.array.length + 10];
            System.arraycopy(buffer, 0, array, 0, buffer.length);
            array[size] = e;
            size++;
        }
    }

    @Override
        public void clear() {
        for (int i = 0; i < array.length; ++i) {
            array[i] = null;
        }
        this.size = 0;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < this.size; i++) {
                if (array[i] == null) {
                    remover(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (o.equals(this.array[i])) {
                    remover(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void remover(int i) {
        int position = this.size - i - 1;

        if (position > 0) {
            System.arraycopy(this.array, i + 1, this.array, i, position);
        }
        this.array[--this.size] = null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.array, this.size);
    }

    @Override
    public int size() {
        if (this.size < array.length) {
            this.array = Arrays.copyOf(array, size);
        }
        return size;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < this.size; i++) {
                if (array[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (o.equals(this.array[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        int yCounter = 0;
        int amountEl = 0;
        for (Object el : c.toArray()) {
            amountEl++;
            for (int i = 0; i < size; i++) {
                if (el.equals(array[i])) {
                    yCounter++;

                }
            }
        }
        return yCounter == amountEl;
    }
    public String toString() {
        StringBuilder s =new StringBuilder();
        s.append("[");
        for (int i = 0; i < size; i++) {
            s.append(array[i]+", ");
        }
        s.delete(s.length()-2,s.length());
        s.append("]");
        return s.toString();

    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        int cursor;
        int lastReturn;
        public boolean hasNext() {
        	return cursor != size;
        }

        @Override
        public Object next() {
            int temporaryCursor=this.cursor;
            if(temporaryCursor>=size){
                throw new NoSuchElementException();
            }
            this.cursor=temporaryCursor+1;
            return array[lastReturn = temporaryCursor];
        }

        public void remove() {
            if(this.lastReturn<0) {
                throw new IllegalStateException();
            }
                MyListImpl.this.remove(array[this.lastReturn]);
                this.cursor=this.lastReturn;
                this.lastReturn=-1;
        }
    }



    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {

        @Override
        public boolean hasPrevious() {
            return this.cursor != 0;
        }
        @Override
        public Object previous() {
            int temporaryCursor= this.cursor-1;
           if(temporaryCursor<0){
               throw new NoSuchElementException();
           }else {
               this.cursor=temporaryCursor;
               return array[this.lastReturn=cursor];
           }
        }

        @Override
        public void set(Object e) {
            array[lastReturn] = e;
        }
    }
}
