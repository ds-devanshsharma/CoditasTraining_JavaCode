package Practice.NestedClass;
class One{
    static void staticDisplayOne(){
        System.out.println("This is from staticDiaplayOne() method !!");
    }
    void displayOne(){
        System.out.println("This is DisplayOne() method !");
        //local inner class
        class Two{
            static void staticShowTwo(){
                System.out.println("This is from StaticShowTwo() method!");
            }
            void showTwo(){
                System.out.println("This is ShowTwo() method !!");
            }
        }
        Two.staticShowTwo();
        new Two().showTwo();

    }
}
public class LocalInnerClass {
    public static void main(String[] args) {
        One.staticDisplayOne();
        new One().displayOne();

    }
}
/*
Local Inner Class
This is from staticDiaplayOne() method !!
This is DisplayOne() method !
This is from StaticShowTwo() method!
This is ShowTwo() method !!
 */