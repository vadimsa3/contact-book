package contact.book.models;

import contact.book.servises.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@Component
public class InitContacts {

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
            FileReader fr = new FileReader(fileNameLoad);
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                String[] contacts = scan.nextLine().split(";");
                String name = contacts[0];
                String phone = contacts[1];
                String email = contacts[2];
                contactsList.add(new Person(name, phone, email));
            }
            fr.close();
            contactBook.setPersons(contactsList);
        } catch (IOException ex) {
            log.warning("Ошибка чтения файла.");
            ex.printStackTrace();
        }
    }
}