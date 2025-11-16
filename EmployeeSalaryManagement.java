import java.util.Scanner;

class Employee{
    String name;
    int id;
    double baseSalary;
    double grossSalary;
    
    Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
        grossSalary = baseSalary*1.3;
    }

    void display() {
        System.out.printf("%-5d     %-15s      %-10.2f      %-10.2f\n", id, name, baseSalary, grossSalary);
    }
}

class Company {
    Employee employees[];
    int index = 0;
    Company(int size) {
        employees = new Employee[size];
    }

    void addEmployee(Employee employee) {
        employees[index] = employee;
        index++;
    }

    void findLowestGrossSalary() {
        double min = employees[0].grossSalary;
        for(int i = 1; i < index; i++) {
            if(employees[i].grossSalary < min){
                min = employees[i].grossSalary;
            }
        }
        System.out.println("\nThe employess with the lowest gross salary: ");
        System.out.print("ID            Name               Base Salary     Gross Salary\n");
        System.out.println("--------------------------------------------------------------");
        for(int i = 0; i < index; i++) {
            if(employees[i].grossSalary == min) {
                employees[i].display();
            }
        }
    }

    void findHighestGrossSalary() {
        double max = employees[0].grossSalary;
        for(int i = 1; i < index; i++) {
            if(employees[i].grossSalary > max) {
                max = employees[i].grossSalary;
            }
        }
        System.out.println("\nThe employess with the highest gross salary: ");
        System.out.print("ID            Name               Base Salary     Gross Salary\n");
        System.out.println("--------------------------------------------------------------");
        for(int i = 0; i < index; i++) {
            if(employees[i].grossSalary == max) {
                employees[i].display();
            }
        }
    }

    void findAvgGrossSalary() {
        double sum = 0;
        for(int i = 0; i < index; i++) {
            sum += employees[i].grossSalary;
        }
        System.out.println();
        System.out.println("The average gross salary: " + (sum/index));
    }

    void displayAllEmployees() {
        System.out.println("ID            Name               Base Salary     Gross Salary\n");
        System.out.println("--------------------------------------------------------------");
        for(int i = 0; i < index; i++) {
            employees[i].display();
        }
        System.out.println();
    }
}

public class EmployeeSalaryManagement {
    public static void main(String[] args) {
        
        Scanner accept = new Scanner(System.in);
        System.out.print("Input number of employees: ");
        int n = accept.nextInt();
        Company company = new Company(n);
        for(int i = 1; i <= n; i++) {
            System.out.println();
            System.out.print("Employee ID: ");
            int id = accept.nextInt();
            accept.nextLine();
            System.out.print("Employee Name: ");
            String name = accept.nextLine();
            System.out.print("Base Salary: ");
            double baseSalary = accept.nextDouble();
            company.addEmployee(new Employee(name, id, baseSalary));
        }
        accept.close();
        company.displayAllEmployees();
        company.findLowestGrossSalary();
        company.findHighestGrossSalary();
        company.findAvgGrossSalary();
    }
}
