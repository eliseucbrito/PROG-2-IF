
package negocio;
import dados.Teacher;
import excecao.EmptyVectorException;
import excecao.TeacherNotFoundException;
import excecao.FullVectorException;

public interface TeacherRegistrationInterface {
    public void insert(Teacher te) throws FullVectorException;
    public Teacher consult (String Siap) throws TeacherNotFoundException, EmptyVectorException;
    public void remove (String Siap) throws TeacherNotFoundException, EmptyVectorException;
    public Teacher[] list() throws EmptyVectorException;
    public void update(Teacher te) throws TeacherNotFoundException, EmptyVectorException;
    public void change (String name,String Siap,int NivelAcess) throws EmptyVectorException, TeacherNotFoundException;
    
}
