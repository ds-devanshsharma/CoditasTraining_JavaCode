package coreJAVA.Week_1.Day_2;

class CPU {
    double price;
    // nested class
    class Processor{
        // members of nested class
        double cores;
        String manufacturer;
        double getCache(){
            return 4.3;
        }
    }
    // nested protected class
    protected class RAM{
        // members of protected nested class
        double memory;
        String manufacturer;
        double getClockSpeed(){
            return 5.5;
        }
    }
}
public class DriverClass_Q1 {
    public static void main(String[] args) {
        CPU cpu_Object = new CPU();
        /* for accessing innerClass member we need to follow
        *  outerClass.innerClass referenceName = object_of_outerClass.new innerClass();
        * */
        CPU.Processor processorObject =cpu_Object.new Processor();
        cpu_Object.price= 3000.95;
        System.out.println( "CPU price is : "+cpu_Object.price);

        processorObject.cores = 4;
        processorObject.manufacturer = "AMD";

        System.out.println("No of cores : "+processorObject.cores);
        System.out.println("manufactures of the processor is : "+ processorObject.manufacturer);
        System.out.println(processorObject.getCache());

        CPU.RAM ramObject = cpu_Object.new RAM();

        ramObject.manufacturer = "SAMSUNG";
        ramObject.memory = 1024;

        System.out.println("Manufacturer os the ram : "+ramObject.manufacturer);
        System.out.println("Memory of Memory : "+ramObject.memory);
        System.out.println(ramObject.getClockSpeed());


    }
}
