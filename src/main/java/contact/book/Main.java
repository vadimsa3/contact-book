package contact.book;

import contact.book.config.AppConfig;
import contact.book.servises.MainMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.logging.Logger;

public class Main {

    private static final java.util.logging.Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(AppConfig.class, args);
        Environment env = context.getEnvironment();
        log.info("Currently active profile(s): " + Arrays.toString(env.getActiveProfiles()));
        context.getBean(MainMenu.class).menu();
    }
}