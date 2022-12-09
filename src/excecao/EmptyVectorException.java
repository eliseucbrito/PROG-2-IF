package excecao;

public class EmptyVectorException extends Exception{

    public EmptyVectorException() {
        super("Vector is empty");
    }
}
