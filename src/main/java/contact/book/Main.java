package contact.book;

import contact.book.config.AppConfig;
import contact.book.servises.MainMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(MainMenu.class).menu();
    }
}