package JDBC.Day3;

public class Teacher {
    int tID;
    String name;
    String Designation;

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public Teacher(int tID, String name, String designation) {
        this.tID = tID;
        this.name = name;
        Designation = designation;
    }
}
