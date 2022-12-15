package fachada;
import dados.Teacher;
import dados.Reserve;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.ReserveNotExistsException;
import excecao.ReserveNotFoundedException;
import excecao.TeacherNotFoundException;
import excecao.*;

public interface SaeInterface {
    public void registerReservation (Reserve re) throws FullVectorException;
    public void removeReserve (String id) throws ReserveNotFoundedException, EmptyVectorException;
    public void changeReserve (String id, int op, String newValue) throws ReserveNotExistsException, EmptyVectorException, TeacherNotFoundException, ReserveNotFoundedException, FullVectorException;
    public Reserve consultReserve (String id) throws ReserveNotFoundedException, EmptyVectorException;
    public void updateReserve (Reserve re) throws EmptyVectorException, ReserveNotFoundedException;
    public Reserve[] listReserves() throws EmptyVectorException;

}
