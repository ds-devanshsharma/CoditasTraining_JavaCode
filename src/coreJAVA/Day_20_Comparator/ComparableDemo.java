package coreJAVA.Day_20_Comparator;

import java.util.ArrayList;
import java.util.Collections;


class JavaPeeps implements Comparable<JavaPeeps>{
    int id;
    String name;

    @Override
    public String toString() {
        return "JavaPeeps{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public int compareTo(JavaPeeps o) {
        return o.name.compareTo(name);
    }


}
//class sortById implements Comparable<JavaPeeps>
//{
//
//    @Override
//    public int compareTo(JavaPeeps o2) {
//        return o2.id-id;
//    }
//}
//class sortByName implements  Comparator<JavaPeeps>
//{
//
//    @Override
//    public int compare(JavaPeeps o1, JavaPeeps o2) {
//        return o1.name.compareTo(o2.name);
//    }
//}
public class ComparableDemo {
    public static void main(String[] args) {

        ArrayList<JavaPeeps> treeSet = new ArrayList<>();

        JavaPeeps javaPeeps = new JavaPeeps();
        javaPeeps.id=10;
        javaPeeps.name="Anuj";
        treeSet.add(javaPeeps);
        JavaPeeps javaPeeps1 = new JavaPeeps();
        javaPeeps1.name="Shailesh";
        javaPeeps1.id=9;
        treeSet.add(javaPeeps1);
        Collections.sort(treeSet);
        System.out.println(treeSet);

    }
}
