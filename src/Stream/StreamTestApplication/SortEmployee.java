package Stream.StreamTestApplication;

import Stream.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployee {
//    to print list
    static void listPrinter(List<Employee> list){
        for(Employee employee : list )
            System.out.println(employee);
    }
    void sortBySalary(List<Employee> list ){
        List<Employee> sortBySalaryList=list.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
        listPrinter(sortBySalaryList);

    }
    void sortByName(List<Employee> list ){
        List<Employee> sortByNameList =list.stream()
                .sorted(new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                })
                .collect(Collectors.toList());
        listPrinter(sortByNameList);
    }


}
