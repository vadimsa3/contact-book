package contact.book.profiles;

import contact.book.servises.GetContacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class InitEnv implements EnvContacts {

    @Value("${contacts-settings.file-load}")
    private String fileNameLoad;

    @Autowired
    private GetContacts getContacts;

    @Override
    public void choiceEnv() {
        System.out.println("Запуск профиля Init");
        getContacts.readContactBookFromFile(fileNameLoad);
    }
}
