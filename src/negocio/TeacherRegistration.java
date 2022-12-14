package negocio;
import repositorio.TeacherRepository;
import dados.Teacher;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.TeacherNotFoundException;
import repositorio.TeacherRepository;

public class TeacherRegistration implements TeacherRegistrationInterface {

    private TeacherRepository teacherRepository;

    public TeacherRegistration() {
        this.teacherRepository = new TeacherRepository();
    }

    @Override
    public void insert(Teacher t) throws FullVectorException {
        this.teacherRepository.insert(t);

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

    public void update(Teacher t) throws EmptyVectorException, TeacherNotFoundException {
        this.teacherRepository.update(t);
    }
}
