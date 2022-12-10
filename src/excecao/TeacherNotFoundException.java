package excecao;

public class TeacherNotFoundException extends Exception{
    public TeacherNotFoundException() {
        super("Teacher Not Found");
    }
}
