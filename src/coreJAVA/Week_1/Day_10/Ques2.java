package coreJAVA.Week_1.Day_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Using Methods of java.lang.Class package
 */
class Order{
   private  int orderId;
   public String orderName;
   public String orderType;
   protected float price;

    Order(){
        System.out.println("This is from OrderClass Constructor !!");
    }

    public Order(int orderId, String orderName, float price) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.price = price;
    }

    public Order(int orderId, float price) {
        this.orderId = orderId;
        this.price = price;
    }

    public void orderDisplay(){
        System.out.println("This is Your Order details : ");
    }
    public void orderCount(){
        System.out.println("This is your count of order :");
    }
}
class SubOrder extends Order{

}
public class Ques2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c = Class.forName("coreJAVA.Week_1.Day_10.Order");
        System.out.println("Class details : " );
        System.out.println("Full Classified ClassName : "+c.getName()); // coreJAVA.Week_1.Day_10.Order
        System.out.println("ClassName : "+c.getSimpleName()); // Order
        System.out.println("SuperClass Of Order Clas : "+c.getSuperclass());
        System.out.println("----------------------------------------------");
        //getting information about constaructor
        System.out.println("Constructors of "+c.getSimpleName()+" are : " );
        Constructor[] consArray = c.getConstructors();
        System.out.println(Arrays.toString(consArray));
        System.out.println("----------------------------------------------");
        //getting information
        System.out.println("Methods of "+c.getSimpleName()+" are : ");
        Method[] methods = c.getMethods();
        System.out.println(Arrays.toString(methods));
        System.out.println("----------------------------------------------");

        //getFields() with give you only public field
        Field[] fields1 = c.getFields();
        System.out.println("Fields of "+c.getSimpleName()+" are :\n ");
        //getField("FieldName") will give you only public Field that you have passed as parameter
        System.out.println("Field of OrderClass using getField('StringName') : \n"+c.getField("orderType"));

        //getDeclaredFields() will give you private ,public,protected all Fields of that class
        Field[] fields2 = c.getDeclaredFields();
        System.out.println("Private , public ,protected " +
                "All Fields of OrderClass : \n"+Arrays.toString(fields2)+"\n");

    }
}
/*
Class details :
Full Classified ClassName : coreJAVA.Week_1.Day_10.Order
ClassName : Order
SuperClass Of Order Clas : class java.lang.Object
----------------------------------------------
Constructors of Order are :
[public coreJAVA.Week_1.Day_10.Order(int,float), public coreJAVA.Week_1.Day_10.Order(int,java.lang.String,float)]
----------------------------------------------
Methods of Order are :
[public void coreJAVA.Week_1.Day_10.Order.orderDisplay(), public void coreJAVA.Week_1.Day_10.Order.orderCount(), public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException, public final void java.lang.Object.wait() throws java.lang.InterruptedException, public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException, public boolean java.lang.Object.equals(java.lang.Object), public java.lang.String java.lang.Object.toString(), public native int java.lang.Object.hashCode(), public final native java.lang.Class java.lang.Object.getClass(), public final native void java.lang.Object.notify(), public final native void java.lang.Object.notifyAll()]
----------------------------------------------
Fields of Order are :

Field of OrderClass using getField('StringName') :
public java.lang.String coreJAVA.Week_1.Day_10.Order.orderType
Private , public ,protected All Fields of OrderClass :
[private int coreJAVA.Week_1.Day_10.Order.orderId, public java.lang.String coreJAVA.Week_1.Day_10.Order.orderName, public java.lang.String coreJAVA.Week_1.Day_10.Order.orderType, protected float coreJAVA.Week_1.Day_10.Order.price]

 */