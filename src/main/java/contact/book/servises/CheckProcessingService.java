package contact.book.servises;

import contact.book.exceptions.IllegalInputException;
import contact.book.models.ContactBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CheckProcessingService {

    private static final java.util.logging.Logger log = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private ContactBook contactBook;

    public void isFullNameInputCorrect(String fullNameInput) throws IllegalInputException {
        String fullNamePattern
                = "^\\s*([\\wА-Яа-я]+)(\\s+([\\wА-Яа-я]?)\\S*)?(\\s+([\\wА-Яа-я]?)[\\wА-Яа-я]*.*)?";
        Pattern pattern = Pattern.compile(fullNamePattern);
        Matcher matcher = pattern.matcher(fullNameInput);
        if (!matcher.matches()) {
            throw new IllegalInputException();
        }
    }

    public void isPhoneNumberInputCorrect(String phoneInput) throws IllegalInputException {
        String phonePattern
                = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3,4}\\)?[\\- ]?)?[\\d\\- ]{5,10}$" +
                "|^((8|\\+375)[\\- ]?)?(\\(?\\d{2,4}\\)?[\\- ]?)?[\\d\\- ]{5,10}$";
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(phoneInput);
        if (!matcher.matches()) {
            throw new IllegalInputException();
        }
    }

    public void isEmailInputCorrect(String mailInput) throws IllegalInputException {
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(mailInput);
        if (!matcher.matches()) {
            throw new IllegalInputException();
        }
    }

    public void defaultCaseMainMenu(String numberInput) throws IllegalInputException {
        String defaultPattern = "\\d+";
        Pattern pattern = Pattern.compile(defaultPattern);
        Matcher matcher = pattern.matcher(numberInput);
        if (!matcher.matches()) {
            throw new IllegalInputException();
        }
    }
}