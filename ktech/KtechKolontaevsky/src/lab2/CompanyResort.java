package lab2;

import java.util.Comparator;

public abstract class CompanyResort implements Comparable {

    int price;
    void bookResort(){}

    @Override
    public int compareTo(Object o) {
        CompanyResort ob= (CompanyResort) o;
        return (int) (this.price-ob.price);
    }

}
abstract class BySea extends CompanyResort{

    abstract void haveSunBath();

    @Override
    public void bookResort(){
        System.out.println("resort by sea has been booked");
        haveSunBath();
    }

    @Override
    public String toString() {
        return "sea";
    }
}
abstract class InMountains extends CompanyResort {
    abstract void climbTheMountain();

    abstract void goSkiing();

    @Override
    void bookResort() {
        System.out.println("resort in the mountains has been booked");
        climbTheMountain();
        goSkiing();
    }

    @Override
    public String toString() {
        return "mountains";
    }
}
abstract class InMegapolis extends CompanyResort{
    abstract void getDrunk();
    abstract void haveHangout();

    @Override
    void bookResort() {
        System.out.println("resort in MEGAPOLIS has been booked");
        getDrunk();
        haveHangout();
    }

    @Override
    public String toString() {
        return "megapolis";
    }
}

class CmpPrice implements Comparator<CompanyResort>{

    @Override
    public int compare(CompanyResort companyResort, CompanyResort t1) {
        return companyResort.price-t1.price;
    }
}
class CmpToStrings implements Comparator<CompanyResort>{
    @Override
    public int compare(CompanyResort companyResort, CompanyResort t1) {
        return companyResort.toString().length()-t1.toString().length();
    }
}