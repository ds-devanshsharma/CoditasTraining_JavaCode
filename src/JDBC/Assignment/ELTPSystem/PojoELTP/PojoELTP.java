package JDBC.Assignment.ELTPSystem.PojoELTP;

public class PojoELTP {
    int batchID;
    String batchName;
    int studentCount;
    String trainerName;
    String joinDate;

    @Override
    public String toString() {
        return "PojoELTP{" +
                "batchID=" + batchID +
                ", batchName='" + batchName + '\'' +
                ", studentCount=" + studentCount +
                ", trainerName='" + trainerName + '\'' +
                ", joinDate='" + joinDate + '\'' +
                '}';
    }

    public int getBatchID() {
        return batchID;
    }

    public void setBatchID(int batchID) {
        this.batchID = batchID;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public PojoELTP(int batchID, String batchName, int studentCount, String trainerName, String joinDate) {
        this.batchID = batchID;
        this.batchName = batchName;
        this.studentCount = studentCount;
        this.trainerName = trainerName;
        this.joinDate = joinDate;
    }
    public PojoELTP(){

    }
}
