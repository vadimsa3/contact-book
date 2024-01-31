package contact.book.servises;

import contact.book.models.ContactBook;
import contact.book.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    private ContactBook contactBook;

    @Value("${contacts-settings}")
    private String fileNameSave;

    private static final java.util.logging.Logger log = Logger.getLogger(PersonService.class.getName());

    public void saveNewPersonToContactBook() {
        System.out.println("Введите данные в порядке: Ф.И.О, номер телефона, адрес электронной почты");
        Scanner scannerNewPerson = new Scanner(System.in);
        String fullName = scannerNewPerson.nextLine();
        String phoneNumber = scannerNewPerson.nextLine();
        String email = scannerNewPerson.nextLine();
        contactBook.getPersons().add(new Person(fullName, phoneNumber, email));
    }

    public void showContactBook() {
        System.out.println("Список контактов:");
        if (!contactBookIsEmpty()) {
            contactBook.getPersons().forEach(person ->
                    System.out.println(person.getFullName() +
                            " | " + person.getPhoneNumber() +
                            " | " + person.getEmail()));
        }
        System.out.println();
    }

    public void deletePersonFromContactBook() {
        System.out.println("Введите email контакта для удаления: ");
        Scanner scannerEmail = new Scanner(System.in);
        String emailDelete = scannerEmail.nextLine();
        if (!contactBookIsEmpty()) {
            contactBook.getPersons().removeIf(person -> emailDelete.equals(person.getEmail()));
        }
    }

    public void findPersonFromContactBook() {
        System.out.println("Введите email контакта для поиска: ");
        Scanner scannerEmail = new Scanner(System.in);
        String emailFind = scannerEmail.nextLine();
        if (!contactBookIsEmpty()) {
            contactBook.getPersons().stream().filter(person ->
                    person.getEmail().contains(emailFind)).forEach(Person::printInfo);
        }
    }

    private boolean contactBookIsEmpty() {
        if (contactBook.getPersons().isEmpty()) {
            log.warning("Список контактов пуст.");
        }
        return false;
    }

    public void saveContactBookToFile() {
        try {
            FileWriter writer = new FileWriter(fileNameSave);
            contactBook.getPersons().forEach(person ->
            {
                try {
                    writer.write(person.getFullName() +
                            ";" + person.getPhoneNumber() +
                            ";" + person.getEmail() + ";" + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.flush();
            writer.close();
        } catch (IOException e) {
            log.warning("Ошибка записи в файл.");
            e.printStackTrace();
        }
    }
}