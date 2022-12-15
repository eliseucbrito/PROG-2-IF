
package fachada;

import dados.Teacher;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.TeacherNotFoundException;
import negocio.TeacherRegistration;
public class SaeTeacher implements SaeTeacherInterface {
    
    private TeacherRegistration teacherRegistration;

    public SaeTeacher() {
        this.teacherRegistration = new TeacherRegistration();
    }
  @Override
    public void insertTeacher(Teacher te) throws FullVectorException{
        this.teacherRegistration.insert(te);
    }
   @Override
    public Teacher consultTeacher(String Siap) throws EmptyVectorException, TeacherNotFoundException{
        return this.teacherRegistration.consult(Siap);
        
    }
    @Override
    public void removeTeacher(String Siap) throws TeacherNotFoundException, EmptyVectorException {
        this.teacherRegistration.remove(Siap);
        
    }
    @Override
    public Teacher[] listTeacher()throws EmptyVectorException{
        return this.teacherRegistration.list();
    }
    @Override
    public void changeTeacher (String nome, String Siap, int NivelAcess) throws TeacherNotFoundException,EmptyVectorException{
        this.teacherRegistration.change(nome,Siap,NivelAcess);
    } 
    
    @Override
    public void updateTeacher(Teacher te)throws EmptyVectorException, TeacherNotFoundException{
        this.teacherRegistration.update(te);
    }
}

    

    