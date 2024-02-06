package contact.book;

import contact.book.config.AppConfig;
import contact.book.servises.MainMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

//        SpringApplication app = new SpringApplication(AppConfig.class);
//        app.setAdditionalProfiles("read");
//        app.run(args);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(MainMenu.class).menu();
    }
}