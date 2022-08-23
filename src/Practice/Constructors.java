package Practice;
class Constructor {
    int id ;
    String Name ;
    private static Constructor constructor ;
    private  Constructor() {

    }
    public static Constructor getConstructor(){
        return new Constructor();
    }
    public void show(){
        System.out.println("Hello Java!!");
    }
}
public class Constructors {
    public static void main(String[] args) {
        Constructor obj = Constructor .getConstructor() ;
        obj.show();
    }
}
