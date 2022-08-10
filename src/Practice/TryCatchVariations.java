package Practice;

public class TryCatchVariations {
    public static void main(String[] args) {
        System.out.println("Line1");
        try{
            System.out.println("inside Try line 2");
            try{
                System.out.println("Nested try line 3");
                System.out.println(10/0);
            }
            finally {
                System.out.println("finally  block line 4");
            }
        }catch (NullPointerException e){
            System.out.println("inside catch line 5" );
            e.printStackTrace();
        }
        finally {
            System.out.println("inside finally line 6");
        }
        System.out.println("Line 7");
    }
}
