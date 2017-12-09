import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class IDThree {
    public static void main(String[] args) {
        //String path = System.getProperties().getProperty("user.dir");
        //System.out.println(path);
        File file = new File("employeeData.xml");
//        String path = file.getAbsolutePath();
//        System.out.println(path);
        //load data from file
        ArrayList<Employee> employeeList = DataLoader.loadData(file);
        runningProgram(employeeList);
        //after operations save data toFile
        DataSaver.saveData(employeeList);
    }

    //main program
    private static void runningProgram(ArrayList<Employee> employeeList){
        while(true){
            char c='a';
            Scanner scanner = new Scanner(System.in);
            showMenu();
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
                    new ID3Util().runIDThreeAlgorithm(employeeList);
                    new RulePrinter().print();
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

    private static void showMenu() {
        System.out.println("please input a char to decide what to do next:");
        System.out.println("input a(means add) to add a new employee.");
        System.out.println("input d(means delete) to delete an employee form the data source.");
        System.out.println("input s(means show) to show all the employee in the list.");
        System.out.println("input r(means run) to run the program to get the decision-making tree.");
    }


    //add a new Employee to the list
    private static ArrayList<Employee> addEmployee(ArrayList<Employee> employeeList){

        return employeeList;
    }
    //delete an employee from the list
    private static ArrayList<Employee> deleteEmployee(ArrayList<Employee> employeeList,int id){
        return employeeList;
    }
    //show the information of the list
    private static void showEmployees(ArrayList<Employee> employeeList){
        for (Employee anEmployeeList : employeeList) {
            showEmployee(anEmployeeList);
        }
    }
    //show information of a single employee
    private static void showEmployee(Employee e){
        System.out.println("Id:"+e.getId());
        System.out.println("EducationLevel:"+e.getEducationLevel());
        System.out.println("Sex:"+e.getSex());
        System.out.println("EnglishLevel:"+e.getEnglishLevel());
        System.out.println("CharacterType:"+e.getCharacterType());
        System.out.println("PostType:"+e.getPostType());
        System.out.println("ClassType:"+e.getClassType());
        System.out.println();
    }
}
