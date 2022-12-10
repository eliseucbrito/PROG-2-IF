package negocio;
import dados.Teacher;
import excecao.EmptyVectorException;
import excecao.TeacherNotFoundException;
import excecao.FullVectorException;
public interface TeacherRegistrationInterface {
    public void insert(Teacher t) throws FullVectorException;
    public Teacher consult (String Siap) throws TeacherNotFoundException, EmptyVectorException;
    public void remove (String Siap) throws TeacherNotFoundException, EmptyVectorException;
    public void change (Teacher t) throws EmptyVectorException, TeacherNotFoundException;
    public Teacher[] list() throws EmptyVectorException;

}
