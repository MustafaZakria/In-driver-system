package sprint1;

import java.util.Scanner;

public class Sprint1 {
    
    public static void main(String[] args) {
        ApplicationSystem system = new ApplicationSystem();
        Admin admin = new Admin(system);
        
        Scanner scan = new Scanner(System.in);
        
        while(true){
            System.out.println("1- Register\n2- Login\n3- Admin\n4- Exit");
            int choice = scan.nextInt();
            if(choice == 1){
                int registrationChoice;
                System.out.println("1- Driver\n2- Customer");
                registrationChoice = scan.nextInt();
                
                if(registrationChoice == 1){
                    Driver driver = new Driver();
                    driver.register();
                    system.addPendingDriver(driver);
                } else if (registrationChoice == 2) {
                    Customer customer = new Customer();
                    customer.register();
                    system.addUser(customer);
                } else 
                    System.out.println("invalid choice");
                
            }
            else if (choice == 2){
                System.out.print("Enter username: ");
                String username = scan.next();
                
                System.out.print("Enter password: ");
                String password = scan.next();
                
                if(system.login(username, password)  == null) {
                    System.out.println("User not registred");
                    
                } else if (system.login(username, password).isSuspend()) {
                    System.out.println("User is suspend");
        
                } else if (system.login(username, password).getType() == Type.Customer) {
                     Customer customer = (Customer) system.login(username, password);
                     System.out.println("Welcome: " + customer.getUsername());
                } else if (system.login(username, password).getType() == Type.Driver) {
                    Driver driver = (Driver) system.login(username, password);
                     System.out.println("Welcome: " + driver.getUsername());
                }
                
            } else if(choice == 3) {
                System.out.println("Welcome Admin");
                System.out.println("1-List All Pending Drivers\n2- Suspend User");
                
                int adminChoice = scan.nextInt();
               
                if(adminChoice == 1){
                    admin.getPendingDriverList();    
                     System.out.println("1-Verify Drivers\n2- Exit from Admin");
                     int listChoice = scan.nextInt();
                     
                     switch(listChoice){
                         case 1:
                             admin.verify();
                             break;
                         case 2:
                             break;
                         default:
                             System.out.println("invaild choice");
                             
                     }
                } else if(adminChoice == 2){
                    admin.suspendUser();
                }
                
            } else if (choice == 4) 
                break;
        }
        system.getUsers();
    }
    
}
