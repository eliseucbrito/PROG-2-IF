
package fachada;

import dados.Teacher;
import excecao.EmptyVectorException;
import excecao.TeacherNotFoundException;
import excecao.FullVectorException;
public interface SaeTeacherInterface {
    public void insertTeacher(Teacher te) throws FullVectorException;
    public Teacher consultTeacher(String Siap) throws TeacherNotFoundException, EmptyVectorException;
    public void removeTeacher (String Siap) throws TeacherNotFoundException, EmptyVectorException;
    public Teacher[] listTeacher()throws EmptyVectorException;
    public void updateTeacher (Teacher te) throws TeacherNotFoundException, EmptyVectorException;
    public void changeTeacher (String name,String Siap,int NivelAcess) throws EmptyVectorException, TeacherNotFoundException;
    
}
