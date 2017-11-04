package ua.nure.zabara.SummaryTask3.entity;

import java.util.ArrayList;
import java.util.List;

public class Ammunitia {

    private List<Weapon> weapons;

    public List<Weapon> getWeapons() {
        if(weapons==null) {
            weapons=new ArrayList<Weapon>();
        }
        return weapons;
    }

    @Override
    public String toString() {
        if(weapons==null || weapons.size() == 0 ){
            return "Ammunitia is empty";
        }
        StringBuilder res=new StringBuilder();
        for(Weapon wep : weapons){
            res.append(wep).append('\n');
        }
        return res.toString();
    }
}
