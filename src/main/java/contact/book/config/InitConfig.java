package contact.book.config;

import contact.book.profiles.EnvContacts;
import contact.book.profiles.InitEnv;
import org.springframework.context.annotation.*;


@PropertySource("classpath:application.yml")
@Configuration
@Profile("init")
public class InitConfig {

    @Bean
    public EnvContacts envContacts() {
        return new InitEnv();
    }
}
