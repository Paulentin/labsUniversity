package lab3;



import lab2.Instrument;

import java.util.Iterator;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyListImpl implements IMyList {
    protected int modCount = 0;

    int size;
    private MyListImpl.Node first;
    private MyListImpl.Node last;

    public MyListImpl(){
        this.size=0;
    }

    private static class Node<Instrument> {
        Instrument item;
        MyListImpl.Node<Instrument> next;
        MyListImpl.Node<Instrument> prev;

        Node(MyListImpl.Node<Instrument> var1, Instrument var2, MyListImpl.Node<Instrument> var3) {
            this.item = var2;
            this.next = var3;
            this.prev = var1;
        }
    }

    @Override
    public void add(Instrument e) {
        this.linkLast(e);

    }
    MyListImpl.Node<Instrument> node(int var1) {
        MyListImpl.Node var2;
        int var3;
        if (var1 < this.size >> 1) {
            var2 = this.first;

            for(var3 = 0; var3 < var1; ++var3) {
                var2 = var2.next;
            }

            return var2;
        } else {
            var2 = this.last;

            for(var3 = this.size - 1; var3 > var1; --var3) {
                var2 = var2.prev;
            }

            return var2;
        }
    }

    void linkLast(Instrument var1) {
        MyListImpl.Node var2 = this.last;
        MyListImpl.Node var3 = new MyListImpl.Node(var2, var1, (MyListImpl.Node)null);
        this.last = var3;
        if (var2 == null) {
            this.first = var3;
        } else {
            var2.next = var3;
        }

        ++this.size;
        ++this.modCount;
    }

    @Override
    public void clear() {
        MyListImpl.Node var2;
        for(MyListImpl.Node var1 = this.first; var1 != null; var1 = var2) {
            var2 = var1.next;
            var1.item = null;
            var1.next = null;
            var1.prev = null;
        }

        this.first = this.last = null;
        this.size = 0;
        ++this.modCount;
    }

    @Override
    public Instrument[] toArray() {
        Instrument[] var1 = new Instrument[this.size];
        int var2 = 0;

        for(MyListImpl.Node var3 = this.first; var3 != null; var3 = var3.next) {
            var1[var2++] = (Instrument) var3.item;
        }
        return var1;
    }

    @Override
    public boolean contains(Instrument e) {
        return this.indexOf(e) != -1;
    }

    public int indexOf(Object var1) {
        int var2 = 0;
        MyListImpl.Node var3;
        if (var1 == null) for(var3 = this.first; var3 != null; var3 = var3.next) {
                if (var3.item == null) return var2;
                ++var2;
        }
        else for(var3 = this.first; var3 != null; var3 = var3.next) {
                if (var1.equals(var3.item)) return var2;
                ++var2;
        }
        return -1;
    }

    @Override
    public boolean remove() {
        if(this.removeFirst()!=null)return true;
        return false;
    }

    public Instrument removeFirst() {
        MyListImpl.Node var1 = this.first;
        if (var1 == null) throw new NoSuchElementException();
        else return this.unlinkFirst(var1);
    }

    private Instrument unlinkFirst(MyListImpl.Node<Instrument> var1) {
        Instrument var2 = var1.item;
        MyListImpl.Node var3 = var1.next;
        var1.item = null;
        var1.next = null;
        this.first = var3;
        if (var3 == null) this.last = null;
        else var3.prev = null;
        --this.size;
        ++this.modCount;
        return var2;
    }

    public String toString() {
        StringBuilder s =new StringBuilder();
        s.append("[");


        MyListImpl.Node<Instrument> prev;
        int k=0;
        for(prev = this.first; prev != null; prev = prev.next) {
            s.append(" element:"+k++ +" ");
            s.append(prev.item.toString()+" |");
        }
        s.delete(s.length()-2,s.length());
        s.append("]");
        return s.toString();

    }



    public Iterator<Instrument> iterator() {
        return new IteratorImpl(0);
    }

    private class IteratorImpl implements Iterator<Instrument> {

        private MyListImpl.Node<Instrument> lastReturned;
        private MyListImpl.Node<Instrument> next;
        private int nextIndex;

        IteratorImpl(int var2) {
//            this.expectedModCount = LinkedList.this.modCount;
            this.next = var2 == MyListImpl.this.size ? null : MyListImpl.this.node(var2);
            this.nextIndex = var2;
        }


        public boolean hasNext() { // проверяет, есть ли следующий элемент для выборки методом next
            // ...
//            return this.next.next!=null;
            return nextIndex < MyListImpl.this.size;
        }

        boolean isCalled;
        public Instrument next() { // возвращает следующий элемент
            // ...
            isCalled = true;
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            } else {
                this.lastReturned = this.next;

                this.next = this.next.next;
                ++this.nextIndex;
                return this.lastReturned.item;
            }
        }
        public void remove() {
            if(isCalled){
                this.lastReturned=null;
                isCalled=false;
            }else {
                throw new IllegalStateException();}
        }
    }

}


