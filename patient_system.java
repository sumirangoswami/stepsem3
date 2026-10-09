class Patient {
    String name;
    double consultationFee;

    
    Patient(String name, double consultationFee) {
        this.name = name;
        this.consultationFee = consultationFee;
    }

    
    double calculateFinalAmount(double fee) {
        double discount = fee >= 2000 ? fee * 0.10 : fee * 0.05;
        return fee - discount;
    }

    
    double calculateDiscount(double fee) {
        return fee >= 2000 ? fee * 0.10 : fee * 0.05;
    }

    
    void display() {
        double discount = calculateDiscount(consultationFee);
        double finalAmount = calculateFinalAmount(consultationFee);

        System.out.println("Patient Name : " + name);
        System.out.println("Original Consultation Fee : ₹" + consultationFee);
        System.out.println("Discount : ₹" + discount);
        System.out.println("Final Amount : ₹" + finalAmount);
        System.out.println("--------------------------------");
    }
}

public class patient_system {
    public static void main(String[] args) {

        
        Patient[] patients = new Patient[5];

        patients[0] = new Patient("Rahul", 2500);
        patients[1] = new Patient("Priya", 1800);
        patients[2] = new Patient("Arun", 3000);
        patients[3] = new Patient("Sneha", 1500);
        patients[4] = new Patient("Kiran", 2200);

        
        for (int i = 0; i < 5; i++) {
            patients[i].display();
        }
    }
}