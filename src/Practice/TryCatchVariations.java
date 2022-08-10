package Practice;

public class TryCatchVariations {
    public static void main(String[] args) {
        System.out.println("Line1");
        try{
            System.out.println("inside Try line 2");
            System.out.println(10/0);
        }catch (Exception e){
            System.out.println("inside catch line 3" );
            e.printStackTrace();
        }
        finally {
            System.out.println("inside finally line 4");
        }
        System.out.println("Line 5");
    }
}
