package repositorio;

import dados.Reserve;

public interface ReserveInterface {
    public void registerReservation (Reserve re);
    public void removeReserve (String id);
    public void changeReserve (String id);

    public Reserve ConsultReserve (String id);

    public Reserve[] list();
}
