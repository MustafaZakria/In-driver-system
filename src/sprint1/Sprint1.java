package sprint1;

import java.util.Scanner;

public class Sprint1 {
    
    public static void main(String[] args) {
    	
        ApplicationSystem system = ApplicationSystem.getInstance();
        Admin admin = new Admin(system);
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        
        while(true){
            System.out.println("1- Register\n2- Login\n3- Admin\n4- Exit");
            int choice = scan.nextInt();
            //scan.nextLine();
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
                    menu.displayCustomerMenu(system, customer, admin);
                    
                } else 
                    System.out.println("invalid choice");
                
            }
            else if (choice == 2){

                User user = system.login();
            	if(user  == null) {
                    System.out.println("User not registred");
                    
                } else if (user.isSuspend()) {
                    System.out.println("User is suspend");
        
                } else if (user.getType() == Type.Customer) {
                     Customer customer = (Customer) user;
                     menu.displayCustomerMenu(system, customer, admin);
                     
                     
                } else if (user.getType() == Type.Driver) {
                    Driver driver = (Driver) user;
                    menu.displayDriverMenu(system, driver);
                    

                }
                
            } else if(choice == 3) {
            	menu.displayAdminMenu(admin);
                
            } else if (choice == 4) 
                break;
        }
        
       
    }
    
}
