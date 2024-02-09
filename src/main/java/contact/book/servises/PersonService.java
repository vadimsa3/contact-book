package contact.book.servises;

import contact.book.exceptions.IllegalInputException;
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

    @Autowired
    private CheckProcessingService checkProcessingService;

    @Value("${file-save}")
    private String fileNameSave;

    private static final java.util.logging.Logger log = Logger.getLogger(PersonService.class.getName());

    public void saveNewPersonToContactBook() {
        System.out.println("Введите данные в следующем порядке: Ф.И.О, номер телефона, адрес электронной почты");
        Scanner scannerNewPerson = new Scanner(System.in);
        try {
            String fullName = scannerNewPerson.nextLine();
            checkProcessingService.isFullNameInputCorrect(fullName);
            String phoneNumber = scannerNewPerson.nextLine();
            checkProcessingService.isPhoneNumberInputCorrect(phoneNumber);
            String email = scannerNewPerson.nextLine();
            checkProcessingService.isEmailInputCorrect(email);
            Person newPerson = new Person(fullName, phoneNumber, email);
            contactBook.getPersons().add(newPerson);
            log.info("Новый контакт успешно сохранен.");
        } catch (IllegalInputException exception) {
            log.warning(exception.getMessage());
        }
    }

    public void showContactBook() {
        System.out.println("Список контактов:");
        if (isContactBookEmpty()) {
            contactBook.getPersons().forEach(person ->
                    System.out.println(person.getFullName() +
                            " | " + person.getPhoneNumber() +
                            " | " + person.getEmail()));
        }
        System.out.println();
    }

    // проверка на правильность адреса и наличия в базе, сюда внести
    public void deletePersonFromContactBook() throws IllegalInputException {
        System.out.println("Введите email контакта для удаления: ");
        Scanner scannerEmail = new Scanner(System.in);
        String emailToDelete = scannerEmail.nextLine();
        if (isContactBookEmpty()) {
            contactBook.getPersons().removeIf(person -> emailToDelete.equals(person.getEmail()));
        }
    }

    public void findPersonFromContactBook() {
        System.out.println("Введите email контакта для поиска: ");
        Scanner scannerEmail = new Scanner(System.in);
        String emailFind = scannerEmail.nextLine();
        if (isContactBookEmpty()) {
            contactBook.getPersons().stream()
                    .filter(person -> person.getEmail().equals(emailFind))
                    .forEach(Person::printInfo);
        }
    }

    private boolean isContactBookEmpty() {
        if (contactBook.getPersons().isEmpty()) {
            log.warning("Список контактов пуст.");
        }
        return true;
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