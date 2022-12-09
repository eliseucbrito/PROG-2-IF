package excecao;

public class ReserveNotFoundedException extends Exception{

    public ReserveNotFoundedException() {
        super("Reserve not founded");
    }
}
