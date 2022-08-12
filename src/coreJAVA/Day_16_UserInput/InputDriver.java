package coreJAVA.Day_16_UserInput;

import java.io.IOException;

public class InputDriver {
    public static void main(String[] args) throws IOException {
        Employee employee = new Employee();
        //This is from Commandline
//        Ques2CLI.inputDetails(args,employee);
//        Ques2CLI.printDetails(employee);
        Ques2BR.inputDetails(employee);
        Ques2BR.printDetails(employee);
    }
}
/*
this is from commandLine:
Employee{id=101, name='Devansh', salary=1200.0}

this is from bufferReader:
Enter ID :
11067
Enter Name :
Devansh Sharma
Enter salaray :
45000
This is from BufferReader !
Employee{id=11067, name='Devansh Sharma', salary=45

 */