package contact.book.servises;

import contact.book.exceptions.IllegalInputException;
import contact.book.profiles.ProfileWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;
import java.util.logging.Logger;

@Service
public class MainMenu {

    @Autowired
    private PersonService personService;

    @Autowired
    private ProfileWorker profileWorker;

    @Autowired
    private CheckProcessingService checkProcessingService;

    private static final java.util.logging.Logger log = Logger.getLogger(MainMenu.class.getName());

    public void menu() {
        profileWorker.doWork();
        while (true) {
            System.out.println("""
                    Перечень команд для работы с контактами:
                    1 - Получение списка контактов.
                    2 - Добавление нового контакта в список.
                    3 - Удаление контакта по email.
                    4 - Поиск контакта по email.
                    5 - Выход (с сохранением изменений).""");
            System.out.println("Введите номер команды: ");
            try {
                Scanner scannerMenu = new Scanner(System.in);
                if (scannerMenu.hasNextInt()) {
                    int numberMenu = scannerMenu.nextInt();
                    switch (numberMenu) {
                        case 1 -> personService.showContactBook();
                        case 2 -> personService.saveNewPersonToContactBook();
                        case 3 -> personService.deletePersonFromContactBook();
                        case 4 -> personService.findPersonFromContactBook();
                        case 5 -> {
                            System.out.println("Завершение работы.");
                            personService.saveContactBookToFile();
                            System.exit(0);
                        }
                        default -> {
                            checkProcessingService.defaultCaseMainMenu(scannerMenu.nextLine());
                            continue;
                        }
                    }
                } else {
                    log.warning("Необходимо ввести корректный цифровой номер команды.");
                }
            } catch (IllegalInputException exception) {
                log.warning(exception.getMessage());
            }
        }
    }
}