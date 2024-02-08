package contact.book.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Getter
@Setter
@NoArgsConstructor
@Component

public class Person {

    private String fullName;
    private String phoneNumber;
    private String email;

    public Person(String fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void printInfo() {
        System.out.println(MessageFormat.format("Person info: {0}, {1}, {2}", fullName, phoneNumber, email));
    }
}