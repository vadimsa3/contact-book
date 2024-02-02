package contact.book.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileWorker {

    @Autowired
    private EnvContacts envContacts;

    public void doWork() {
        envContacts.choiceEnv();
    }
}
