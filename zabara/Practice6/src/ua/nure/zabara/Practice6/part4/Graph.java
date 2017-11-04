package ua.nure.zabara.Practice6.part4;

import java.util.*;

public class Graph {
    List<Vertex> vertexList;
    int vertAmount;

    Graph(int vertAmount){
        this.vertAmount=vertAmount;
    }

    public void add(Vertex connectTo,Vertex connectWhat){
        /*
        * if the vertex to which we want to add another one is in vertexList
        * and amount of added vertexes doesn't exceeds given vertAmount
        *                   then add vertex
        * */
        if(vertexList ==null){
            addFirst(connectTo);
        }

        if(vertAmount>0){
            boolean res=connectTo.addVertex(connectWhat);
                if(res){
                    vertexList.add(connectWhat);
                    vertAmount--;
                }else {
                    throw new IllegalArgumentException();
                }
        }else{
            System.err.println("Graph is full  "+ vertAmount);
            return;
        }

    }

    public void addFirst(Vertex addFirst){
        vertexList = new LinkedList<>();
        vertexList.add(addFirst);
        vertAmount--;
    }


}


class Vertex{

    Integer value;
    Set<Vertex> connectedTo=new LinkedHashSet<>();

    Vertex(Integer value){
        this.value=value;
    }

    public boolean addVertex(Vertex connectWhat){
        if (!connectedTo.contains(connectWhat)){

            System.out.println(connectWhat.value+" added");
            return connectedTo.add(connectWhat);
        }else {
            System.err.println("Vertex has this vertex in connection");
            return false;
        }
    }


    @Override
    public int hashCode() {
        System.out.println("hash");
        return 31*value;
    }


    @Override
    public boolean equals(Object o) {
        System.out.println("Equals");
        return super.equals(o);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public void printConnections(){
        System.out.print("Value: "+value + "|");
        for(Vertex v: connectedTo){
            System.out.print(v.value+" ");
        }
        System.out.println();
    }
}