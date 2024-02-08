import contact.book.models.ContactBook;
import contact.book.models.Person;
import contact.book.servises.GetContacts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    @DisplayName("Test - isEmailInputCorrect")
    @Test
    void testisEmailInputCorrect() throws IOException {
        String emailPattern
                = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String validEmail = "vadim@mail.ru";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(validEmail);
        System.out.println(matcher.matches());
    }

    @DisplayName("Test - isPhoneNumberInputCorrect")
    @Test
    void testIsPhoneNumberInputCorrect() {
        String phonePattern
                = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3,4}\\)?[\\- ]?)?[\\d\\- ]{5,10}$" +
                "|^((8|\\+375)[\\- ]?)?(\\(?\\d{2,4}\\)?[\\- ]?)?[\\d\\- ]{5,10}$";
        String[] validPhoneNumbers
                = {"+375(29)563-35-35", "+375(17)2325656", "+375293699887", "+375 29 369 98 87",
                "+79261234567", "89261234567", "+7 926 123 45 67", "8(926)123-45-67", "123-45-67", "(495)1234567",
                "(495) 123 45 67", "89261234567", "8-926-123-45-67", "8 927 1234 234"};
        Pattern pattern = Pattern.compile(phonePattern);
        for (String phoneNumber : validPhoneNumbers) {
            Matcher matcher = pattern.matcher(phoneNumber);
            System.out.println(matcher.matches());
        }
    }

    @DisplayName("Test - isFullNameInputCorrect")
    @Test
    void testIsFullNameInputCorrect() {
        String fullNamePattern
                = "^\\s*([\\wА-Яа-я]+)(\\s+([\\wА-Яа-я]?)\\S*)?(\\s+([\\wА-Яа-я]?)[\\wА-Яа-я]*.*)?";
        String[] checkFullName
                = {"Савчук Вадим Геннадьевич", "Савчук Геннадьевич", "+375293699887", "Савчук В.Г.",
                "Savchuk Vadim", "Иностранец"};
        Pattern pattern = Pattern.compile(fullNamePattern);
        for (String fullName : checkFullName) {
            Matcher matcher = pattern.matcher(fullName);
            System.out.println(matcher.matches());
        }
    }
}

