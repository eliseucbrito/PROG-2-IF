
package repositorio;

import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.KeyNotFoundException;
import dados.Key;
public class KeyRepository implements KeyRepositoryInterface {
    
    private static final int MAX = 10;
    private Key[] Keys;
    private int index;

    public KeyRepository(){
        this.Keys = new Key[MAX];
        this.index = -1;

    }
    
  @Override
   public void insert(Key key) throws FullVectorException {
        this.index = this.index+1;
        if(this.index<MAX){
            Keys[index] = key;

        }else{
          throw new FullVectorException();

        }
    }
   
   
    @Override
    public Key consult  (String name)throws KeyNotFoundException,EmptyVectorException {
        Key k = null;
        if(this.index >=0){
            boolean find = false;
            int indexfind = 0;
            for(int i = 0; i <= this.index;i=i+1){
                if(name.equals(this.Keys[i].getName())){
                indexfind = i;
                find = true;
                break;
                }
            }
            if(find == true){
                k = this.Keys[indexfind];

            }else{
                throw new KeyNotFoundException();
            }
        }else{
            throw new EmptyVectorException();
        }
        return k;
    }

   @Override
    public void remove(String name) throws KeyNotFoundException, EmptyVectorException {
        if(this.index>=0){
            boolean find = false;
            int indexfind = 0;
            for(int i = 0; i<=this.index;i=i+1) {
                if(name.equals(this.Keys[i].getName())){
                    find = true;
                    indexfind = i;
                    break;
                }
            }
            if(find == true){
                for(int i = indexfind; i<index;i=i+1){
                    this.Keys[i]=this.Keys[i+1];
                     this.index = this.index - 1;
                }
                this.Keys[this.index] = null;
                this.index = this.index - 1;
            }else{
                throw new KeyNotFoundException();
                
            }
        }else{
            throw new EmptyVectorException();
        }
    }

   @Override
    public void update(Key k) throws EmptyVectorException, KeyNotFoundException {
        Key keyold = this.consult(k.getName());
        keyold = k;

    }
  
   
    @Override
    public Key[] list() throws EmptyVectorException {
       Key ks[] = null;
        if(this.index>=0){
            ks = new Key[this.index+1];
            for(int i = 0; i <= index; i=i+1) {
                ks[i] = this.Keys[i];
            }
        }else{
            throw new EmptyVectorException();
        }
        return ks;

    }



}
