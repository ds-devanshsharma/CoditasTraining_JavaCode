package Practice.ExceptionHandling;

public class CustomException extends RuntimeException{
    CustomException(String s){
        System.out.println(s);
        System.out.println("CustomException");
    }
}
