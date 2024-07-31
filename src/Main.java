import java.util.ArrayList;

// This is the Parent Class of FullTimeEmployee and PartTimeEmployee classes
abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name: "+name+", id: "+id+", salary: "+calculateSalary();
    }
}

//This is FullTimeEmployee class which extends Employee class
class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name,id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

//This is PartTimeEmployee class
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;

    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}

//This is PayrollSystem class which controls arrangement of Employees or Details of Employees
class PayrollSystem{
    private ArrayList<Employee> employeeArrayList;
    public PayrollSystem(){
        employeeArrayList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeArrayList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeArrayList){
            if(employee.getId() == id){
                employeeToRemove = employee;
                break;
            }

        }
        if(employeeToRemove != null)  employeeArrayList.remove(employeeToRemove);
    }

    public void displayEmployee(){
        for(Employee employee: employeeArrayList){
            System.out.println(employee);
        }
    }

}


public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Priyanshu",1,60000.00);
        PartTimeEmployee emp2 = new PartTimeEmployee("Subham", 2, 40, 400);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employees details int the list");
        payrollSystem.displayEmployee();
        payrollSystem.removeEmployee(2);
        System.out.println("Employees List after removing Employee");
        payrollSystem.displayEmployee();
    }
}