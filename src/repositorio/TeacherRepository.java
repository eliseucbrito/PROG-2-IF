package repositorio;


import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.TeacherNotFoundException;
import dados.Teacher;
public class TeacherRepository implements TeacherInterface{
    private static final int MAX = 10;
    private Teacher[] Teachers;
    private int index;

    public TeacherRepository(){
        this.Teachers = new Teacher[MAX];
        this.index = -1;

    }
    @Override
    public void insert(Teacher t) throws FullVectorException {
        this.index = this.index+1;
        if(this.index<MAX){
            Teachers[index] = t;

        }else{
          throw new FullVectorException();

        }
    }
    @Override
    public Teacher consult (String Siap)throws TeacherNotFoundException,EmptyVectorException {
        Teacher te = null;
        if(this.index >=0){
            boolean find = false;
            int indexfind = 0;
            for(int i = 0; i <= this.index;i=i+1){
                if(Siap.equals(this.Teachers[i].getSiap())){
                indexfind = i;
                find = true;
                break;
                }
            }
            if(find == true){
                te = this.Teachers[indexfind];

            }else{
                throw new TeacherNotFoundException();
            }
        }else{
            throw new EmptyVectorException();
        }
        return te;
    }

    @Override
    public void remove(String Siap) throws TeacherNotFoundException, EmptyVectorException {
        if(this.index>=0){
            boolean find = false;
            int indexfind = 0;
            for(int i = 0; i<=this.index;i=i+1) {
                if(Siap.equals(this.Teachers[i].getName())){
                    find = true;
                    indexfind = i;
                    break;
                }
            }
            if(find == true){
                for(int i = indexfind; i<index;i=i+1){
                    this.Teachers[i]=this.Teachers[i+1];

                }
            }else{
                throw new TeacherNotFoundException();

            }
        }else{
            throw new EmptyVectorException();
        }
    }

    @Override
    public void update(Teacher t) throws EmptyVectorException, TeacherNotFoundException {
        Teacher t_old = this.consult(t.getSiap());
        t_old = t;

    }

    @Override
    public Teacher[] list() throws EmptyVectorException {
        Teacher ts[] = null;
        if(this.index>=0){
            ts = new Teacher[this.index+1];
            for(int i = 0; i <= index; i=i+1) {
                ts[i] = this.Teachers[i];
            }
        }else{
            throw new EmptyVectorException();
        }
        return ts;

    }



}
