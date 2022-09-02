package JDBC.Assignment.JavaPeeps;

public class JavaPeepsPOJO {
    int internID;
    String Name;
    String city;
    String education;

    public JavaPeepsPOJO() {
    }

    public JavaPeepsPOJO(int internID, String name, String city, String education) {
        this.internID = internID;
        Name = name;
        this.city = city;
        this.education = education;
    }

    public int getInternID() {
        return internID;
    }

    public void setInternID(int internID) {
        this.internID = internID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "["+internID+","+ Name+","+city+","+education+"]";
    }
}
