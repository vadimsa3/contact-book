package contact.book.servises;

import contact.book.models.ContactBook;
import contact.book.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@Service
public class GetContacts {

//    @Value("${contacts-settings}")
//    private String fileNameLoad;

    @Autowired
    private Person person;

    @Autowired
    private ContactBook contactBook;

    public static List<Person> contactsList = new ArrayList<>();

    private static final java.util.logging.Logger log = Logger.getLogger(PersonService.class.getName());

    public void readContactBookFromFile(String fileNameLoad) {
        try {
            FileReader fileReader = new FileReader(fileNameLoad);
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {
                String[] contacts = scan.nextLine().split(";");
                String name = contacts[0];
                String phone = contacts[1];
                String email = contacts[2];
                contactsList.add(new Person(name, phone, email));
            }
            fileReader.close();
            contactBook.setPersons(contactsList);
        } catch (IOException ex) {
            log.warning("Ошибка чтения файла.");
            ex.printStackTrace();
        }
    }
}