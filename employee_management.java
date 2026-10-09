class Employee {
    int empId;
    String name;
    double monthlySalary;

    
    Employee(int empId, String name, double monthlySalary) {
        this.empId = empId;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    
    void displayDetails() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Name : " + name);
        System.out.println("Monthly Salary : ₹" + monthlySalary);
    }

    
    double annualSalary() {
        return monthlySalary * 12;
    }

    
    double calculateBonus() {
        return monthlySalary >= 30000 ? annualSalary() * 0.10 : 0;
    }

    
    String bonusEligibility() {
        return monthlySalary >= 30000 ? "Eligible" : "Not Eligible";
    }

    
    void display() {
        displayDetails();
        System.out.println("Annual Salary : ₹" + annualSalary());
        System.out.println("Bonus : ₹" + calculateBonus());
        System.out.println("Bonus Eligibility : " + bonusEligibility());
        System.out.println("--------------------------------");
    }
}

public class employee_management {
    public static void main(String[] args) {

        
        Employee[] employees = new Employee[5];

        employees[0] = new Employee(101, "Rahul", 35000);
        employees[1] = new Employee(102, "Priya", 28000);
        employees[2] = new Employee(103, "Arun", 45000);
        employees[3] = new Employee(104, "Sneha", 30000);
        employees[4] = new Employee(105, "Kiran", 25000);

        
        for (int i = 0; i < 5; i++) {
            employees[i].display();
        }
    }
}