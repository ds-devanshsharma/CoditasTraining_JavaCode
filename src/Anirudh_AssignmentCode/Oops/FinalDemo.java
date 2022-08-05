package Anirudh_AssignmentCode.Oops;

public class FinalDemo {
    public static void main(String[] args) {
        // Final variable have to be initialised while declaring it
        final  int NUM =10;
        // you  can't modify NUM =11;

        /* Immutablity is You cant Modify the value for primitives but
        // while working with non-primitive type final Variable You can change the value inside store in Object
           but you can't reassign new Object to that reference
         */
       final Emp e = new Emp(101,"Devansh Sharma ");
       e.e_id = 12;
       /*   Can't re-assign New object to final non-primitive variable||
        //   when a primitive is final You can't reassign */
//          e = new Emp();

    }
}
class Emp{
    public Emp(int e_id,String name) {
        this.e_id = e_id;
        this.name = name;
    }

    int e_id =10;
    String name = "Devansh ";
}
