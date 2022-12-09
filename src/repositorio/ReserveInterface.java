package repositorio;

import dados.Reserve;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.ReserveNotExistsException;
import excecao.ReserveNotFoundedException;

public interface ReserveInterface {
    public void registerReservation (Reserve re) throws FullVectorException;
    public void removeReserve (String id) throws ReserveNotFoundedException, EmptyVectorException;
    public void changeReserve (String id, String infoChange, String newValue) throws ReserveNotExistsException, EmptyVectorException;

    public Reserve ConsultReserve (String id);

    public Reserve[] list();
}
