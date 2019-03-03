package Package;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    private String id;
    @OneToMany (cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddyInfos;


    public AddressBook() {
        buddyInfos = new ArrayList<BuddyInfo>();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        for (BuddyInfo e : buddyInfos){
            System.out.println("Name: " + e.getName() + " Number: " + e.getNumber());
        }
        return "";
    }

    public List<BuddyInfo> getBuddyInfos(){
        return buddyInfos;
    }

    public void add(BuddyInfo b){

        buddyInfos.add(b);
    }

    public void remove (BuddyInfo b){

        buddyInfos.remove(b);
    }


    public int getSize(){
        return buddyInfos.size();
    }



    public static void main (String [] args){
        AddressBook book1 = new AddressBook();

        BuddyInfo buddy1 = new BuddyInfo("Ahmed", 905524479);
        BuddyInfo buddy2 = new BuddyInfo("Birat", 416918537);
        BuddyInfo buddy3 = new BuddyInfo("Jack", 905254689);

        book1.buddyInfos.add(buddy1);
        book1.buddyInfos.add(buddy2);
        book1.buddyInfos.add(buddy3);

        book1.toString();
    }




}
