package negocio;

import dados.Reserve;
import dados.Teacher;
import excecao.*;
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

    @Override
    public Reserve changeReserve(String id, int op, String newValue) throws ReserveNotExistsException, EmptyVectorException, ReserveNotFoundedException, TeacherNotFoundException, FullVectorException {
        return null;
    }

    @Override
    public Reserve changeReserve(String id, int op, String newValue, Teacher te) throws EmptyVectorException, ReserveNotFoundedException, TeacherNotFoundException, FullVectorException {
        Reserve reChange = this.reserveRepository.consultReserve(id);


        switch (op) {
            case 1: // Teacher
                reChange = this.reserveRepository.consultReserve(id);
                System.out.println("NEW ID "+reChange.getId());
                System.out.println("NEW TEACHER "+reChange.getTeacher());
                System.out.println("NEW SIAPE "+te.getSiap());
                System.out.println("NEW TE NAME "+te.getName());
                reChange.setTeacher(te);
                break;
            case 2: // goal
                reChange.setActivity(newValue);
                break;
            case 3: // goal
                reChange.setSolicitation_hour(newValue);
                break;
            case 4: // goal
                reChange.setDevolution_hour(newValue);
                break;
            default:
                break;
        }
        this.reserveRepository.updateReserve(reChange);
        return reChange;
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
