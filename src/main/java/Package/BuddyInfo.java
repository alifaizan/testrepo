package Package;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BuddyInfo {


    private String name;
    @Id
    private int number;
    private String address;

    public BuddyInfo() {
        this.name = "";
        this.number = 0;
       // this.address = "";
    }

    public BuddyInfo(String name, int number) {
        this.name = name;
        this.number = number;
        //this.address = address;
    }

    public String getName() {

        return name;
    }

    public int getNumber() {

        return number;
    }

    public String getAddress() {

        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(int number){this.number = number;}


    public boolean equals(Object o){
        if (o instanceof BuddyInfo) {
            BuddyInfo newBuddy = (BuddyInfo) o;
            if (this.getNumber() == newBuddy.getNumber()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
            String s = "Name: " + getName() + ", Number: " + getNumber();
            return s;
    }
}
