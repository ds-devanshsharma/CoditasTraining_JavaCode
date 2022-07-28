package coreJAVA.Week_1.Day_8;

import java.util.Random;

/**
 * 3). Create a class Medicine to represent a drug manufactured by a pharmaceutical
 * company. Provide a function displayLabel() in this class to print Name and address of
 * the company.
 * Derive Tablet, Syrup and Ointment classes from the Medicine class.
 * Override the displayLabel() function in each of these classes to print additional
 * information suitable to the type of medicine.
 * For example, in case of tablets, it could be "store in a cool dry place", in case of
 * ointments it could be "for external use only" etc. Create a class TestMedicine. Write
 * main function to do the following: Declare an array of Medicine references of size 10
 * Create a medicine object of the type as decided by a randomly generated integer in the
 * range 1 to 3. Refer Java API Documentation to find out random generation features.
 * Check the polymorphic behavior of the displayLabel() method.
 */

abstract class Medicine{
    String company;
    String address;
    public Medicine(String company, String address) {
        this.company = company;
        this.address = address;
    }

    abstract void displayLabel();
}
class Tablet extends Medicine{
    public Tablet(String company, String address) {
        super(company, address);
    }

    @Override
    void displayLabel() {
        System.out.println("Company :: "+company+" \nAddress :: "+address);
        System.out.println("Tablet must be stored in a cool dry place\n");
    }
}
class Syrup extends Medicine{
    public Syrup(String company, String address) {
        super(company, address);
    }

    @Override
    void displayLabel() {
        System.out.println("Company :: "+company+" \nAddress :: "+address);
        System.out.println("Shake Syrup well before Use\n");
    }
}
class Ointment extends Medicine{
    public Ointment(String company, String address) {
        super(company, address);
    }

    @Override
    void displayLabel() {
        System.out.println("Company :: "+company+" \nAddress :: "+address);
        System.out.println("Ointment for external use only\n");
    }
}

public class TestMedicine {
    public static void main(String[] args) {
        int generatedRandomNumber;
        Medicine[] medicines = new Medicine[10];
        //Random Class
        Random random = new Random();
        /*assigning objects based on randomly generated number
           like if 1 => Tablet
                   2 => Syrup
                   3 => Ointment
         */
        for(int i=0;i<10;i++){
             generatedRandomNumber=random.nextInt(1,4);
             switch (generatedRandomNumber){
                 case 1 :
                     medicines[i] = new Tablet("Cipla","Mumbai");
                     break;
                 case 2 :
                     medicines[i] = new Syrup("Johnson & Johnson"," America");
                     break;
                 case 3 :
                     medicines[i] = new Ointment("SBL"," India");
                     break;
                 default:
                     System.out.println("ERROR 404 !!! ");
             }
        }
        for(Medicine  medicineType : medicines )
            medicineType.displayLabel();
    }
}
/*
                    Company :: Johnson & Johnson
                    Address ::  America
                    Shake Syrup well before Use

                    Company :: Cipla
                    Address :: Mumbai
                    Tablet must be stored in a cool dry place

                    Company :: Johnson & Johnson
                    Address ::  America
                    Shake Syrup well before Use

                    Company :: Cipla
                    Address :: Mumbai
                    Tablet must be stored in a cool dry place

                    Company :: SBL
                    Address ::  India
                    Ointment for external use only

                    Company :: Cipla
                    Address :: Mumbai
                    Tablet must be stored in a cool dry place

                    Company :: SBL
                    Address ::  India
                    Ointment for external use only

                    Company :: SBL
                    Address ::  India
                    Ointment for external use only

                    Company :: SBL
                    Address ::  India
                    Ointment for external use only

                    Company :: Johnson & Johnson
                    Address ::  America
                    Shake Syrup well before Use
 */
