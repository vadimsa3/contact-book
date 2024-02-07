package contact.book.config;

import contact.book.profiles.EnvContacts;
import contact.book.profiles.ReadEnv;
import org.springframework.context.annotation.*;

@Configuration
@Profile("read")
public class ReadConfig {

    @Bean
    public EnvContacts envContacts() {
        return new ReadEnv();
    }
}