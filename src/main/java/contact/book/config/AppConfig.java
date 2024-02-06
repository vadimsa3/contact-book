package contact.book.config;

import contact.book.profiles.EnvContacts;
import contact.book.profiles.InitEnv;
import contact.book.profiles.ReadEnv;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@ComponentScan("contact.book")
@Configuration
@PropertySource("classpath:application.yml")
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(new ClassPathResource("application.yml"));
        configurer.setProperties(yamlPropertiesFactoryBean.getObject());
        return configurer;
    }
}