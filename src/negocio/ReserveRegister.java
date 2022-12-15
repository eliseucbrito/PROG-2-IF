package negocio;

import dados.Reserve;
import dados.Teacher;
import excecao.*;
import repositorio.ReserveInterface;
import repositorio.ReserveRepository;

public class ReserveRegister implements ReserveInterface {

    private ReserveRepository reserveRepository;
    private TeacherRegistration teacherRegistration;

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
    public Reserve changeReserve(String id, int op, String newValue) throws EmptyVectorException, ReserveNotFoundedException, TeacherNotFoundException {
        Reserve reChange = this.reserveRepository.consultReserve(id);


        switch (op) {
            case 1: // Teacher
                Teacher newTeacher = this.teacherRegistration.consult(newValue);
                System.out.println("newTeacher: " + newTeacher);
                reChange.setTeacher(newTeacher);
                break;
            case 2:
                break;
            case 3: // goal
                reChange.setActivity(newValue);
                break;
            case 4: // goal
                reChange.setSolicitation_hour(newValue);
                break;
            case 5: // goal
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
