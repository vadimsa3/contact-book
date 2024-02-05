package contact.book.config;

import contact.book.profiles.EnvContacts;
import contact.book.profiles.InitEnv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("init")
@PropertySource("classpath:application.yml")
public class InitConfig {

    @Bean
    public EnvContacts envContacts() {
        return new InitEnv();
    }
}
