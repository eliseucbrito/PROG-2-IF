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
    public void changeReserve(String id, int op, String newValue) throws EmptyVectorException, TeacherNotFoundException, ReserveNotFoundedException, FullVectorException {
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

}
