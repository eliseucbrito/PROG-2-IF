package negocio;
import repositorio.TeacherRepository;
import dados.Teacher;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.TeacherNotFoundException;


public class TeacherRegistration implements TeacherRegistrationInterface {

    private TeacherRepository teacherRepository;

    public TeacherRegistration() {
        this.teacherRepository = new TeacherRepository();
    }

    @Override
    public void insert(Teacher te) throws FullVectorException {
        this.teacherRepository.insert(te);

    }

    @Override
    public Teacher consult(String Siap) throws TeacherNotFoundException, EmptyVectorException {
        return this.teacherRepository.consult(Siap);
    }

    @Override
    public void remove(String Siap) throws TeacherNotFoundException, EmptyVectorException {
        this.teacherRepository.remove(Siap);

    }

    @Override
    public void change(String name, String Siap, int NivelAcess) throws EmptyVectorException, TeacherNotFoundException {
        Teacher te = this.teacherRepository.consult(Siap);
        te.change(name, Siap, NivelAcess);
        this.teacherRepository.update(te);
    }

    @Override
    public Teacher[] list() throws EmptyVectorException {
        return this.teacherRepository.list();
    }

    public void update(Teacher te) throws EmptyVectorException, TeacherNotFoundException {
        this.teacherRepository.update(te);
    }
}
