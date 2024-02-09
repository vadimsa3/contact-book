package contact.book.exceptions;

public class IllegalInputException extends Exception {

    public IllegalInputException() {
        super("Введено неверное значение. Необходимо ввести верные данные.");
    }
}
