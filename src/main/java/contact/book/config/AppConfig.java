package contact.book.config;

import contact.book.profiles.EnvContacts;
import contact.book.profiles.InitEnv;
import contact.book.profiles.ReadEnv;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Objects;

@ComponentScan("contact.book")
@Configuration
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(new ClassPathResource("application.yml"));
        configurer.setProperties(Objects.requireNonNull(yamlPropertiesFactoryBean.getObject()));
        return configurer;
    }
}