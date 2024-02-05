package contact.book.config;

import contact.book.profiles.EnvContacts;
import contact.book.profiles.ReadEnv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("read")
@PropertySource("classpath:application.yml")
public class ReadConfig {

    @Bean
    public EnvContacts envContacts() {
        return new ReadEnv();
    }
}