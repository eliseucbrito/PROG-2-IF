package excecao;

// exception de vetor cheio
// o jeito que aprendemos com ricardo n funciona na JDK 17
public class FullVectorException extends Exception{

    public FullVectorException() {
        super("Full vector");
    }
}
