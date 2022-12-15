package excecao;

public class ReserveNotExistsException extends Exception{

    public ReserveNotExistsException() {
        super("This reserve not exists");
    }
}