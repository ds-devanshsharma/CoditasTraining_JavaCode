package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** using Stream for basic operations
 *
 */


public class StreamBasicsDemo {
    public void printStream(Integer[] list){
        Arrays.stream(list).forEach(System.out::println);
    }
    public int  addStream(Integer[] list){
        return Arrays.stream(list).mapToInt(x -> x).sum();
    }
    public int addOddStream(Integer[] list){
        return Arrays.stream(list).filter(x ->x%2==0).mapToInt(x ->x ).sum();
    }
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5};

//        new StreamBasicsDemo().printStream(array);
//        System.out.println( new StreamBasicsDemo().addStream(array));
          System.out.println(new StreamBasicsDemo().addOddStream(array));
    }
}
