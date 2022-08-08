package coreJAVA.Week_1.Day_10;
class DatabaseConnection
{
    static DatabaseConnection databaseConnection;
    int a;
    private DatabaseConnection()
    {}
    public static DatabaseConnection getObject()
    {
        if(databaseConnection == null)
        {
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;
    }
}
public class EkHeBnega {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = DatabaseConnection.getObject();
        databaseConnection.a=20;
        System.out.println("hashcode value : "+databaseConnection+" value of a : "+databaseConnection.a);
        databaseConnection.a=30;
        DatabaseConnection databaseConnection1 = DatabaseConnection.getObject();
        databaseConnection1.a=500;
        System.out.println("hashcode value : "+databaseConnection1+" value of a : "+databaseConnection1.a);
        System.out.println("hashcode value : "+databaseConnection+" value of a : "+databaseConnection.a);
    }
}
