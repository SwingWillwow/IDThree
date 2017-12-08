import java.io.File;
import java.util.List;
import java.util.Scanner;

public class IDThree {
    public static void main(String[] args) {
        File file = null;
        //load data from file
        List<Employee> employeeList = DataLoader.loadData(file);
        runningProgram(employeeList);
        //after operations save data toFile
        DataLoader.saveData(file);
    }

    //main program
    private static void runningProgram(List<Employee> employeeList){
        while(true){
            char c='a';
            Scanner scanner = new Scanner(System.in);
            System.out.println("please input a char to decide what to do next:");
            System.out.println("input a(means add) to add a new employee.");
            System.out.println("input d(means delete) to delete an employee form the data source.");
            System.out.println("input s(means show) to show all the employee in the list.");
            System.out.println("input r(means run) to run the program to get the decision-making tree.");
            String inputStr = scanner.next();
            if(inputStr.length()>1){
                System.out.println("error input please input again.");
                continue;
            }
            //get c
            c=inputStr.charAt(0);
            if(c=='#') break;
            switch (c){
                case 'a':
                    employeeList=addEmployee(employeeList);
                    break;
                case 'd':
                    int id=0;
                    employeeList=deleteEmployee(employeeList,id);
                    break;
                case 's':
                    showEmployees(employeeList);
                    break;
                case 'r':
                    break;
                default:
                    c='c';//c for continue;
                    break;
            }
            if(c=='c'){
                System.out.println("error input please input again.");
            }
        }
    }


    //add a new Employee to the list
    private static List<Employee> addEmployee(List<Employee> employeeList){

        return employeeList;
    }
    //delete an employee from the list
    private static List<Employee> deleteEmployee(List<Employee> employeeList,int id){
        return employeeList;
    }
    //show the information of the list
    private static void showEmployees(List<Employee> employeeList){

    }
}
