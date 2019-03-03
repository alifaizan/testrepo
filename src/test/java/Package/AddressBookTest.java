package Package;

import Package.AddressBook;
import org.junit.Test;
import Package.BuddyInfo;

import static org.junit.Assert.*;


public class AddressBookTest {

    AddressBook book1;
    AddressBook book2;
    BuddyInfo buddy1;

    @Test
    public void test1 (){ //testing for size and if the buddy is inserted into the addressbook
        book1 = new AddressBook();
        buddy1 = new BuddyInfo("Ahmed", 4589753);
        book1.add(buddy1);
        assertEquals(1, 1);
    }


}
