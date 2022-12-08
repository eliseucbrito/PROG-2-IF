package repositorio;

import dados.Key;
import dados.Reserve;
import dados.Teacher;

public class ReserveRepository implements ReserveInterface {

    private static final int MAX = 100;
    private Reserve[] reserve;
    private int indice;

    @Override
    public void registerReservation(Reserve re) {
        this.indice = this.indice + 1;
        if (this.indice < MAX) {
            reserve[indice] = re;
        } else {
            System.out.println("Vetor cheio!");
        };
    }

    @Override
    public void removeReserve(String id) {

    }

    @Override
    public void changeReserve(String id) {

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
