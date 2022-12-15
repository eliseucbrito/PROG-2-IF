package fachada;
import dados.Teacher;
import dados.Reserve;
import excecao.*;
import negocio.ReserveRegister;
import negocio.TeacherRegistration;
import excecao.TeacherNotFoundException;

public class Sae implements SaeInterface {

    private ReserveRegister reserveRegister;

    public Sae() {
        this.reserveRegister = new ReserveRegister();
    }


    @Override
    public void registerReservation(Reserve re) throws FullVectorException {
        this.reserveRegister.registerReservation(re);
    }

    @Override
    public void removeReserve(String id) throws ReserveNotFoundedException, EmptyVectorException {
        this.reserveRegister.removeReserve(id);
    }

    @Override
    public void changeReserve(String id, int op, String newValue) throws EmptyVectorException, TeacherNotFoundException, ReserveNotFoundedException {
        this.reserveRegister.changeReserve(id, op, newValue);
    }

    @Override
    public Reserve consultReserve(String id) throws ReserveNotFoundedException, EmptyVectorException {
        return this.reserveRegister.consultReserve(id);
    }

    @Override
    public void updateReserve(Reserve re) throws EmptyVectorException, ReserveNotFoundedException {
        this.reserveRegister.updateReserve(re);
    }

    @Override
    public Reserve[] listReserves() throws EmptyVectorException {
        return this.reserveRegister.list();
    }
//===================================teacher===========================//
    private TeacherRegistration teacherRegistration;

    public Professores() {
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
