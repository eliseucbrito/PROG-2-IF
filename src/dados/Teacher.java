package dados;

public class Teacher {
    private String name;
    private String Siap;

    private int NivelAcess;

    public Teacher(){
        this.name = "";
        this.Siap ="";
        this.NivelAcess = 0;

    }
    public Teacher(String name,String Siap,int NivelAcess) {
        this.name = name;
        this.Siap = Siap;
        this.NivelAcess = NivelAcess;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiap() {
        return Siap;
    }

    public void setSiap(String siap) {
        Siap = siap;
    }
    public int getNivelAcess(){
        return NivelAcess;
    }
    public void NivelAcess(int NivelAcess){
        this.NivelAcess = NivelAcess;
    }

public void change (String name, String Siap,int NivelAcess){
        this.name = name;
        this.Siap = Siap;
        this.NivelAcess = NivelAcess;
}

}
