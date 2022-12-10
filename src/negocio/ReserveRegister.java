package negocio;

import dados.Reserve;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.ReserveNotExistsException;
import excecao.ReserveNotFoundedException;
import repositorio.ReserveInterface;
import repositorio.ReserveRepository;

public class ReserveRegister implements ReserveInterface {

    private ReserveRepository reserveRepository;

    public ReserveRegister() {
        this.reserveRepository = new ReserveRepository();
    }

    @Override
    public void registerReservation(Reserve re) throws FullVectorException {
        this.reserveRepository.registerReservation(re);
    }

    @Override
    public void removeReserve(String id) throws ReserveNotFoundedException, EmptyVectorException {
        this.reserveRepository.removeReserve(id);
    }

    @Override // juntar todos os repositorios
    public void changeReserve(String id, int op, String newValue) throws ReserveNotExistsException, EmptyVectorException {

    }

    @Override
    public Reserve consultReserve(String id) throws ReserveNotFoundedException, EmptyVectorException {
        return this.reserveRepository.consultReserve(id);
    }

    @Override
    public void updateReserve(Reserve re) throws EmptyVectorException, ReserveNotFoundedException {
        this.reserveRepository.updateReserve(re);
    }

    @Override
    public Reserve[] list() throws EmptyVectorException {
        return this.reserveRepository.list();
    }
}
