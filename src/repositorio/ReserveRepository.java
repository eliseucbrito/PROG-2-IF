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

    public ReserveRepository(Reserve[] reserve) {
        this.reserve = new Reserve[MAX];
        this.index = -1;
    }

    @Override
    public void registerReservation(Reserve re) throws FullVectorException {
        this.index = this.index + 1;
        if (this.index < MAX) {
            reserve[index] = re;
        } else {
            throw new FullVectorException();
        };
    }

    @Override
    public void removeReserve(String id) throws ReserveNotFoundedException, EmptyVectorException {
        if (this.index > 0) {
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
    public void changeReserve(String id, String infoChange) throws EmptyVectorException {
        if (this.index > 0) {
            boolean found = false;
            int indexFound = 0;
            Reserve r = null;
            for (int i = 0; i <= this.index; i++) {
                if (id.equals(this.reserve[i].getId())) {
                    found = true;
                    indexFound = i;
                    break;
                }
                if (found) {
                    this.reserve[indexFound] = r;
                }
            }

            switch (infoChange) {
                case "Teacher": // implementar o nome do professor quando tiver feito
                    System.out.println("Current teacher"+ r.getTeacher().getName());
                    System.out.println("New teacher: ");

                    break;
                case "Key":

                    break;
                case "ID":

                    break;
                case "Activity":

                    break;
                case "Solicitarion Hour":

                    break;
                case "Devolution Hour":

                    break;
                default:
                    throw new IllegalArgumentException("Invalid option!");
            }
        } else {
            throw new EmptyVectorException();
        }
    }

    @Override
    public Reserve ConsultReserve(String id) {
        return null;
    }

    @Override
    public Reserve[] list() {
        return new Reserve[0];
    }
}
