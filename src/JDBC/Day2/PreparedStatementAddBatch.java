package JDBC.Day2;

public class PreparedStatementAddBatch {
    public static void main(String[] args) {
        //Driver
        try {
            Class.forName("com.jdbc.mysql.");
        }catch(ClassNotFoundException e ){
            System.out.println(e.getMessage());
        }
    }
}
