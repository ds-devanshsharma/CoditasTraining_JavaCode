package coreJAVA.Day_13;
/**
 * Demo of ClassCastException
 */
class Parent{

}
class Child extends Parent{
    public void show(){
        System.out.println("This from Child show() method :: ");
    }
}
public class Ques1 {
    public static void main(String[] args) {
        //trying to do DownCasting child ref = obj of Parent
        //Child child = new Parent();//this will give you Compilation Error to cast it
        Parent p = new Child();
        try {
            Child child = (Child) new Parent(); // now you safe from CE but
        }catch(ClassCastException e){
            // getMessage()=>  description ||  needed to be written inside print()
            //  System.out.println(e.getMessage());

            // toString() => nameOfException : description ||  needed to be written inside print()
              System.out.println(e.toString());
        }
        finally{
            //this finally block will run for sure in any condition
            Child c = (Child)p;
            c.show();
            System.out.println("This message is from finally block Do not DownCast Parent into Child !!");
        }
    }
}
/*
Without handingCode
Exception in thread "main" java.lang.ClassCastException: class coreJAVA.Week_1.Day_13.Parent cannot be cast to class coreJAVA.Week_1.Day_13.Child (coreJAVA.Week_1.Day_13.Parent and coreJAVA.Week_1.Day_13.Child are in unnamed module of loader 'app')
	at coreJAVA.Week_1.Day_13.Ques1.main(Ques1.java:16)

With TryCatch handlingCode
java.lang.ClassCastException: class coreJAVA.Week_1.Day_13.Parent cannot be cast to class coreJAVA.Week_1.Day_13.Child (coreJAVA.Week_1.Day_13.Parent and coreJAVA.Week_1.Day_13.Child are in unnamed module of loader 'app')

With TryCatch finally Block
java.lang.ClassCastException: class coreJAVA.Week_1.Day_13.Parent cannot be cast to class coreJAVA.Week_1.Day_13.Child (coreJAVA.Week_1.Day_13.Parent and coreJAVA.Week_1.Day_13.Child are in unnamed module of loader 'app')
This from Child show() method ::
This message is from finally block Do not DownCast Parent into Child !!


 */