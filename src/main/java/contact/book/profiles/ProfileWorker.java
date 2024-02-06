package contact.book.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ProfileWorker {

    @Autowired
    private EnvContacts envContacts;

    public void doWork() {
        envContacts.choiceEnv();
    }
}
