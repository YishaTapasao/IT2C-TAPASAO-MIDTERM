package department;

import java.util.Scanner;

public class Department {
        
       public void startMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nSelect options:");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int action = sc.nextInt();
            switch (action) {
                case 1:
                    addRecords();
                    break;
                case 2:
                    viewRecords();
                    break;
                case 3:
                    viewRecords();
                    updateRecords();                   
                    break;
                case 4:
                    deleteRecords();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

    }
       }

        public void addRecords(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Enter Department Name: ");
        String dname = sc.nextLine();
        System.out.print("Enter Department Head: ");
        String dhead = sc.nextLine();
        System.out.print("Enter Location: ");
        String dlocation = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String pnum = sc.next();
        System.out.print("Enter Email: ");
        String email = sc.next();

        String sql = "INSERT INTO records(department_name, department_head, location, phone_number, email) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, dname, dhead, dlocation, pnum, email);     
}
        
        private void viewRecords() {
        String qry = "SELECT * FROM records";
        String[] hdrs = {"ID", "Department Name", "Department Head", "Location", "Number", "Email"};
        String[] clmn = {"id", "department_name", "department_head", "location", "phone_number", "email"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clmn);
    }
        
          private void updateRecords() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Department ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the New Department Name: ");
        String dname = sc.nextLine();
        System.out.print("Enter the New Department Head: ");
        String dhead = sc.nextLine();
        System.out.print("Enter the New Location: ");
        String dlocation = sc.nextLine();
        System.out.print("Enter the New Phone Number: ");
        String pnum = sc.next();
        System.out.print("Enter the New Email: ");
        String email = sc.nextLine();
    
        
        String qry = "UPDATE records SET department_name = ?, department_head = ?, location = ?, phone_number = ? WHERE p_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, dname, dhead, dlocation, pnum, email, id);
        
    }

       public void deleteRecords(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter  Department ID to delete: ");
        int id = sc.nextInt();
        
        String sqlDelete = "DELETE FROM records WHERE department_id = ?";
        config conf = new config();
        conf.deleteRecord(sqlDelete, id);
       } 
          
          
        
    public static void main(String[] args) {      
        
        Department app = new Department();
        app.startMenu();
        
}


}