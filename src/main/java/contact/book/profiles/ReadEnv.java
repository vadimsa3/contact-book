package contact.book.profiles;

import contact.book.models.InitContacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class ReadEnv implements EnvContacts {

    @Value("${contacts-settings}")
    private String fileNameLoad;

    @Autowired
    private InitContacts initContacts;

    @Override
    public void choiceEnv() {
        System.out.println("Запуск профиля Read");
        initContacts.readContactBookFromFile(fileNameLoad);
    }
}