package repositorio;

import dados.Reserve;
import excecao.*;

public interface ReserveInterface {
    public void registerReservation (Reserve re) throws FullVectorException;
    public void removeReserve (String id) throws ReserveNotFoundedException, EmptyVectorException;
    public Reserve changeReserve (String id, int op, String newValue) throws ReserveNotExistsException, EmptyVectorException, ReserveNotFoundedException, TeacherNotFoundException;

    public Reserve consultReserve (String id) throws ReserveNotFoundedException, EmptyVectorException;
    public void updateReserve (Reserve re) throws EmptyVectorException, ReserveNotFoundedException;

    public Reserve[] list() throws EmptyVectorException;
}
