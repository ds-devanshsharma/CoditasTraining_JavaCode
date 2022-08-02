package coreJAVA.Week_1.Day_10;
class Parent{
    void display(){

    }
}
class Child extends Parent{
    static void getDownCast(Parent ppp){
        if(ppp instanceof Child){
            Child c =(Child)ppp;
            System.out.println("Buddy DownCasting is performed");
        }
    }
    void display(){
        System.out.println("Parent p = new Child() :: This is Upcasting !! ");
    }
}
public class CastingDemo {
    public static void main(String[] args) {
        // Parent p = new Parent(); //
        Parent pp = new Child(); //upCasting
    //    pp.display();
    /* downCasting this will resolve CE
        but at Runtime ClassCastException will occurs */

//        Child c =(Child) new Parent();//DownCasting but that doesn't work properly
//        c.display();
        Child.getDownCast(pp);
    }
}
/*
Output ::
Parent p = new Child() :: This is Upcasting !!
--------------------------------------------------------------------------------------
Parent p = new Child() :: This is Upcasting !!
Exception in thread "main" java.lang.ClassCastException: class coreJAVA.Week_1.Day_10.Parent cannot be cast to class coreJAVA.Week_1.Day_10.Child (coreJAVA.Week_1.Day_10.Parent and coreJAVA.Week_1.Day_10.Child are in unnamed module of loader 'app')
	at coreJAVA.Week_1.Day_10.CastingDemo.main(CastingDemo.java:19)
--------------------------------------------------------------------------------------
Buddy DownCasting is performed!!
 */