package repositorio;

import dados.Reserve;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.ReserveNotExistsException;
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

    @Override // Acho que esse metodo vai ter que ser no pacote NEGOCIO, pq vai ter que usar outras classes
    public void changeReserve(String id, int op, String newValue) throws EmptyVectorException {
        Reserve re = null;
        if (this.index > 0) {
            boolean found = false;
            int indexFound = 0;
            Reserve r = null;

            for (int i = 0; i <= this.index; i++) { // Looking for reserve
                if (id.equals(this.reserve[i].getId())) {
                    found = true;
                    indexFound = i;
                    break;
                }
            };

            if (found) {
                re = this.reserve[indexFound];

                switch (op) {
                    case 1: // Teacher

                        break;
                    case 2: // Key

                        break;
                    case 3: // Activity
                        re.setActivity(newValue);
                        break;
                    case 4: // Solicitation Hour
                        re.setSolicitation_hour(newValue);
                        break;
                    case 5: // Devolution Hour
                        re.setDevolution_hour(newValue);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option!");
                }
            }
        } else {
            throw new EmptyVectorException();
        }
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
