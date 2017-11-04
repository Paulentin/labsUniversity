package ua.nure.zabara.Practice6.part3;

import java.util.*;



//// TODO: 8/9/17 not sure if it works properly 
public class Parking {
    

    int capacity=10;
    List <Object> parking= new ArrayList<>();
    Parking(){
        for (int i = 0; i < capacity; i++) {
            parking.add(null);

        }
    }
    public boolean addCar(Object o){

        if (parking.contains(o)){
            return false;
        }

        for (int i = 0; i < capacity; i++) {
           if(parking.get(i)==null){
               parking.add(i,o);
               return true;
           }
        }
        return false;
    }
    public boolean addCar(Object o,int pos){

        if (parking.contains(o)){
            return false;
        }

        for (int i = pos; i < capacity; i++) {
            if(parking.get(i)==null){
                parking.add(i,o);
                return true;
            }
        }
        return false;
    }




    public void removeCar(int index){
       parking.add(index,null);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
