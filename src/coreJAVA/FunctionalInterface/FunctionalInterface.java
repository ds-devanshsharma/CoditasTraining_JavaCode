package coreJAVA.FunctionalInterface;

import java.util.Arrays;

/**
 *  Functional interface is interface that have only one abstract along with any no of default /static method
 */
interface Addition{
    int add(Integer... a);
}
public class FunctionalInterface {
     void anonymousClassDemo(){
        // using add() method
        Addition addition = new Addition() {
            int sum =0;
            @Override
            public int add(Integer... a) {
                for(int item : a)
                    sum += item ;
                return sum;
            }
        };
        System.out.println("Addition of number : "+addition.add(10,100,1000));
    }

    // using lambda Expression
    void lambdaExpressionDemo(){
       Addition addition =(a)->{
              int sum=0;
              for(int i=0;i<a.length;i++)
              {
                  sum+=a[i];
              }
              return sum;
       };

        System.out.println(addition.add(10,20));
    }
    void addStream(){
       Addition addition =(a)-> Arrays.stream(a).mapToInt(x->x).sum();
        System.out.println(addition.add(10,20,30,40));
    }

    public static void main(String[] args) {
       new FunctionalInterface().addStream();
    }
}
