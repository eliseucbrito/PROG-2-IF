package fachada;
import dados.Teacher;
import dados.Reserve;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.ReserveNotExistsException;
import excecao.ReserveNotFoundedException;
import excecao.TeacherNotFoundException;


public interface SaeInterface {
    public void registerReservation (Reserve re) throws FullVectorException;
    public void removeReserve (String id) throws ReserveNotFoundedException, EmptyVectorException;
    public void changeReserve (String id, int op, String newValue) throws ReserveNotExistsException, EmptyVectorException;
    public Reserve consultReserve (String id) throws ReserveNotFoundedException, EmptyVectorException;
    public void updateReserve (Reserve re) throws EmptyVectorException, ReserveNotFoundedException;
    public Reserve[] listReserves() throws EmptyVectorException;
    public void insertTeacher(Teacher te) throws FullVectorException;
    public Teacher consultTeacher(String Siap) throws TeacherNotFoundException, EmptyVectorException;
    public void removeTeacher (String Siap) throws TeacherNotFoundException, EmptyVectorException;
    public Teacher[] listTeacher()throws EmptyVectorException;
    public void updateTeacher (Teacher te) throws TeacherNotFoundException, EmptyVectorException;
    public void changeTeacher (String name,String Siap,int NivelAcess) throws EmptyVectorException, TeacherNotFoundException;
}
