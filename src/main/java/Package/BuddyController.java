package Package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BuddyController {

    @Autowired
    AddressBookRepository addressRepo;
    AddressBook newBook;
    @Autowired
    BuddyRepository BuddyRepo;

    @GetMapping ("/add")
    public String addForm(Model model) {
        model.addAttribute("buddy", new BuddyInfo());
        return "Addform";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute BuddyInfo buddyinfo, Model model) {
        BuddyInfo bud = new BuddyInfo();
        bud = buddyinfo;
        BuddyRepo.save(bud);
        model.addAttribute("buddy", bud);
        return "AddResult";
    }

    @GetMapping ("/all")
    public String display (Model model){
        model.addAttribute( "buddies", BuddyRepo.findAll());
        return "Display";
    }

    @RequestMapping ("/add")
    public String addBuddy (@RequestParam (value = "name") String name, @RequestParam (value = "number") int number, @RequestParam (value = "book") String addressBookID, Model model){


        for (AddressBook address : addressRepo.findAddressBookById(addressBookID)) {
            newBook= address;
        }

        BuddyInfo newBuddy = new BuddyInfo(name, number);
        newBuddy.setId(number);

        BuddyRepo.save(newBuddy);
        newBook.add(newBuddy);


        addressRepo.save(newBook);
        model.addAttribute("addressbook", newBook);
        return "AddressBook";
    }

}