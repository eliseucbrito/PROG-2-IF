package repositorio;

import dados.Teacher;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.TeacherNotFoundException;


public interface TeacherInterface {
    public void insert(Teacher t) throws FullVectorException;
    public Teacher consult (String Siap) throws TeacherNotFoundException, EmptyVectorException;
    public void remove (String Siap) throws TeacherNotFoundException, EmptyVectorException;
    public void update (Teacher t) throws EmptyVectorException, TeacherNotFoundException;
    public Teacher[] list() throws EmptyVectorException;

}
