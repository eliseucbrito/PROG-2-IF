package repositorio;

import dados.Reservation;

public interface ReservationInterface {
    public void registerReservation (Teacher teacher, Key key);
    public void removeReservation (String id);
    public void changeReservation (String id);

    public Reservation ConsultReservation (String id);

    public Reservation[] list();
}
