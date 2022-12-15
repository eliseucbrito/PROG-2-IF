package repositorio;

import dados.Reserve;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.ReserveNotFoundedException;

public class ReserveRepository implements ReserveInterface {

    private static final int MAX = 100;
    private Reserve[] reserve;
    private int index;

    public ReserveRepository() {
        this.reserve = new Reserve[MAX];
        this.index = -1;
    }

    @Override
    public void registerReservation(Reserve re) throws FullVectorException {
        this.index = this.index + 1;
        if (this.index < MAX) {
            reserve[this.index] = re;
        } else {
            throw new FullVectorException();
        };
    }

    @Override
    public void removeReserve(String id) throws ReserveNotFoundedException, EmptyVectorException {
        if (this.index >= 0) {
            boolean found = false;
            int indexFound = 0;
            for (int i = 0; i <= this.index; i++) {
                if (id.equals(this.reserve[i].getId())) {
                    found = true;
                    indexFound = i;
                    break;
                }
            };
            if (found) {
                for (int i = indexFound; i <= index; i++) {
                    this.reserve[i] = this.reserve[i+1];
                };
                this.reserve[this.index] = null; // delete index empty
                this.index = this.index - 1;
            } else {
                throw new ReserveNotFoundedException();
            }
        } else {
            throw new EmptyVectorException();
        }

    }

    @Override
    public Reserve changeReserve(String id, int op, String newValue) throws EmptyVectorException, ReserveNotFoundedException {
        Reserve re = null;
        if (this.index >= 0) {
            boolean found = false;
            int indexFound = 0;
            for (int i = 0; i <= this.index; i++) { // erro de consulta, não tá encontrando
                if (id.equals((this.reserve[i].getId()))) {
                    found = true;
                    indexFound = i;
                    break;
                }
            }
            if (found) {
                re = this.reserve[indexFound];
            } else {
                throw new ReserveNotFoundedException();
            }
        } else {
            throw new EmptyVectorException();
        }
        return re;
    }

    @Override
    public Reserve consultReserve(String id) throws ReserveNotFoundedException, EmptyVectorException {
        Reserve re = null;
        if (this.index >= 0) {
            boolean found = false;
            int indexFound = 0;
            for (int i = 0; i <= this.index; i++) { // erro de consulta, não tá encontrando
                if (id.equals((this.reserve[i].getId()))) {
                    found = true;
                    indexFound = i;
                    break;
                }
            }
            if (found) {
                re = this.reserve[indexFound];
            } else {
                throw new ReserveNotFoundedException();
            }
        } else {
            throw new EmptyVectorException();
        }
        return re;
    }

    @Override
    public void updateReserve(Reserve re) throws EmptyVectorException, ReserveNotFoundedException {
        Reserve reOld = this.consultReserve(re.getId());
        reOld = re;
    }

    @Override
    public Reserve[] list() throws EmptyVectorException {
        Reserve reList[] = null; // creating a new vector of reserves
        if (this.index >= 0) {
            reList = new Reserve[this.index+1];
            for (int i = 0; i <= this.index; i++) { // perguntar sobre o index a ricardo
                reList[i] = this.reserve[i];
            }
        } else {
            throw new EmptyVectorException();
        }
        return reList;
    }
}
