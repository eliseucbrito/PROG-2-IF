package dados;

public class Teacher {
    private String name;
    private String Siap;
    private int age;

    public Teacher(){
        this.name = "";
        this.age = 0;
        this.Siap ="";

    }
    public Teacher(String name,String Siap,int age) {
        this.name = name;
        this.Siap = Siap;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
