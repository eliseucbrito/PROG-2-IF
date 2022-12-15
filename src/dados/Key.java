
package dados;


public class Key {

    private String name;
    private String room;

    public Key(String name, String room) {

        this.name = name;
        this.room = room;
    }

    public Key() {
        this.name = "";
        this.room = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    public void change (String name, String room){
        this.name = name;
        this.room = room;
        
}

}