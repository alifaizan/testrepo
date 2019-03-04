package Package;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface AddressBookRepository extends CrudRepository<AddressBook, String> {

    List<AddressBook> findAddressBookById(String id);
}
