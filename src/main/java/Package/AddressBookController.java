package Package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressRepo;

    @RequestMapping ("/")
    public AddressBook newbook (@RequestParam (value = "name", defaultValue = "book1") String id, Model model){

        AddressBook book = new AddressBook();
        book.setId(id);
        addressRepo.save(book);
        return book;

    }

    @RequestMapping ("/print")
    public int print (@RequestParam (value = "id") String id){
        AddressBook newBook = new AddressBook();

        for (AddressBook address : addressRepo.findAddressBookById(id)) {
            newBook= address;
        }

        return newBook.getSize();

    }
/*
    @PostMapping("/create")
    public String printAddressBook(@ModelAttribute AddressBook print){
        return "Created";

    }
*/
}
