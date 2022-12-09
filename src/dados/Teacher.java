package dados;

public class Teacher {
    private String name;

    public Teacher() {
        this.name = "";
    }
    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
