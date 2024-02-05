package contact.book.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Component
public class ContactBook {

    @Autowired
    private List<Person> persons;
}