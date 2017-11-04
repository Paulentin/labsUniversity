package ua.nure.zabara.Practice6.part5;



public class Tree<E extends Comparable<E>> {


	private static final String INDENT = "   ";

	private Node<E> root = null;


    private Node changeHead(Node<E> node){
        Node tmp = node;
        Node previousNode = null;

        tmp = tmp.leftNode;
        while(tmp.rightNode!=null){
            previousNode=tmp;
            tmp = tmp.rightNode;
        }
        node=tmp;
        previousNode.rightNode=null;   /**deleting object from root of note that will be placed on top of tree(subtree)*/
        return node;
    }


    public boolean remove(E element) {
        Node<E> tmp = root;
        Node<E> previousNode=null;
        /*
        *if element found
        *
        *
        *
        * */
        if (element.compareTo(tmp.getValue())==0){
            root=changeHead(tmp);
            return true;
        }

        while(true){
            System.out.println("true blocked");
            int cmp=element.compareTo(tmp.getValue());
            if(cmp > 0){

                if(tmp.rightNode==null){
                    return false;
                }else{
                    previousNode=tmp;
                    tmp = tmp.rightNode;
                }

            }else if (cmp < 0){

                if(tmp.leftNode==null){
                    return false;
                }else{
                    previousNode=tmp;
                    tmp = tmp.leftNode;
                }

            }else {
                if(element.compareTo(previousNode.rightNode.getValue())==0){
                    previousNode.rightNode=changeHead(tmp);
                } else {
                    previousNode.leftNode=changeHead(tmp);
                }
                return true;
            }
        }
	}
	
	public void add(E[] elements) {
        int middleIndex=elements.length/2;
        int middleEl= (Integer) elements[middleIndex];
        root.setValue(elements[middleEl]);

        for (E element:
             elements) {
            add(element);
        }
    }





	public boolean add(E e) {

        if (root==null) {
            root=new Node<>();
            root.setValue(e);
            return true;
        }

        Node<E> tmp = root;
        Node<E> tmpForComparison=new Node<>();
        tmpForComparison.value=e;

	    while(true){
            int cmp=tmp.compareTo(tmpForComparison);
            System.out.println("Comparison "+cmp);

            if(cmp>0){
                if(tmp.rightNode==null){

                    tmp.rightNode=new Node<>();
                    tmp.rightNode.setValue(e);
                    System.out.println(tmp.rightNode.value + " addded");
                    return true;
                }else{
                    tmp = tmp.rightNode;
                }

            }else if (cmp < 0){
                if(tmp.leftNode==null){

                    tmp.leftNode = new Node<>();
                    tmp.leftNode.setValue(e);
                    System.out.println(tmp.leftNode.value + " addded");
                    return true;
                }else{
                    tmp = tmp.leftNode;
                }
            }else{
                return false;
            }
        }
	}	

	public void print() {
        Node<E> tmpRight=null;
        Node<E> tmpLeft=null;

        if(root.leftNode!=null||root.rightNode!=null){
        tmpLeft=root.leftNode;
        tmpRight=root.rightNode;
            System.out.println(root);
            System.out.println(tmpLeft+" "+tmpRight);

        }
        while(tmpLeft!=null&&tmpRight!=null){
            if (tmpLeft.leftNode!=null||tmpLeft.rightNode!=null){
                tmpLeft=tmpLeft.leftNode;
                tmpRight=tmpLeft.rightNode;
                System.out.println(tmpLeft+ " " + tmpRight);
            }
        }
        tmpLeft=root.leftNode;
        tmpRight=root.rightNode;

        while(tmpLeft!=null&&tmpRight!=null){
            if (tmpRight.leftNode!=null||tmpRight.rightNode!=null){
                tmpLeft=tmpLeft.leftNode;
                tmpRight=tmpLeft.rightNode;
                System.out.println(tmpLeft+ " " + tmpRight);
            }
        }

    }
	
	private static class Node<E>implements Comparable {

        private E value;

	    private Node<E> rightNode;
        private Node<E> leftNode;


        @Override
        public int compareTo(Object o) {

                Node oto=(Node)o;
                return (Integer)this.getValue() -(Integer)oto.getValue();


        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return ""+this.value;
        }
    }

}

