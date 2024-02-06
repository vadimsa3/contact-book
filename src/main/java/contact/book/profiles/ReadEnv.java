package contact.book.profiles;

import contact.book.servises.GetContacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ReadEnv implements EnvContacts {

    @Value("${contacts-settings.file-load}")
    private String fileNameLoad;

    @Autowired
    private GetContacts getContacts;

    @Override
    public void choiceEnv() {
        System.out.println("Запуск профиля Read " + fileNameLoad);
        getContacts.readContactBookFromFile(fileNameLoad);
    }
}