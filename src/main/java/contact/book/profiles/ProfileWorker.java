package contact.book.profiles;

import org.springframework.stereotype.Component;

@Component
public class ProfileWorker {

    private final EnvContacts envContacts;

    public ProfileWorker(EnvContacts envContacts) {
        this.envContacts = envContacts;
    }

    public void doWork() {
        envContacts.choiceEnv();
    }
}
