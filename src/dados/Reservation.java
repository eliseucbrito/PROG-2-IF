package dados;

public class Reservation {
    private Teacher teacher;
    private Key key;
    private String activy;
    private String solicitation_hour;
    private String devolution_hour;

    public Reservation () {
        this.teacher = null;
        this.key = null;
        this.activy = "";
        this.solicitation_hour = "";
        this.devolution_hour = "";
    }

    public Reservation(Teacher teacher, Key key, String activy, String solicitation_hour, String devolution_hour) {
        this.teacher = teacher;
        this.key = key;
        this.activy = activy;
        this.solicitation_hour = solicitation_hour;
        this.devolution_hour = devolution_hour;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getActivy() {
        return activy;
    }

    public void setActivy(String activy) {
        this.activy = activy;
    }

    public String getSolicitation_hour() {
        return solicitation_hour;
    }

    public void setSolicitation_hour(String solicitation_hour) {
        this.solicitation_hour = solicitation_hour;
    }

    public String getDevolution_hour() {
        return devolution_hour;
    }

    public void setDevolution_hour(String devolution_hour) {
        this.devolution_hour = devolution_hour;
    }
};

