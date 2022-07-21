package coreJAVA.Week_1.Day_2;
class Coditas_Result{
    static String company_name= "Coditas";
    int intern_id;

    void evaluation_Result( int id) {
        boolean result=true;
        System.out.println("Organisation "+company_name+"\t"+" student _id : " + intern_id +"\t"+ " confirmation  "+result);
    }
}
public class Types_of_operator_Assignment {
    public static void main(String[] args) {
        Coditas_Result intern1 =new Coditas_Result();
        intern1.intern_id=11057;
        intern1.evaluation_Result(intern1.intern_id);

        //similary we can do for others


    }


}
