package contact.book.exceptions;

public class IllegalInputException extends Exception {

    public IllegalInputException() {
        super("Введено неверное значение в поле контакта. Необходимо ввести верные данные.");
    }
}
