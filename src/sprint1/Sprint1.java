package sprint1;

import java.util.Scanner;

public class Sprint1 {
    
    public static void main(String[] args) {
    	
        ApplicationSystem system = ApplicationSystem.getInstance();
        Admin admin = new Admin(system);
        Menu menu = new Menu();
        try (Scanner scan = new Scanner(System.in)) {
        	
			while(true){
			    System.out.println("1- Register\n2- Login\n3- Admin\n4- Exit");
			    int choice = scan.nextInt();
			    //scan.nextLine();
			    if(choice == 1){
			        int registrationChoice;
			        System.out.println("1- Driver\n2- Customer");
			        
			        registrationChoice = scan.nextInt();
			        
			        if(registrationChoice == 1){
			        	Scanner scann = new Scanner(System.in);
			        	
			            Driver driver = new Driver();
			            
			            System.out.print("Enter Driver Username: ");
			            String username = scann.nextLine();
			            
			            System.out.print("Enter Driver Password: ");
			            String password = scann.nextLine();
			            
			            System.out.print("Enter Driver Mobile: ");
			            String mobile = scann.nextLine();
			            
			            System.out.print("Enter Driver Licence: ");
			            String license = scann.nextLine();
			            
			            System.out.print("Enter Driver National-ID: ");
			            String nationalID = scann.nextLine();
			            
			            System.out.print("Enter Available Seats: ");
			            int availableSeats = scann.nextInt();
			            
			            driver.register( username,  password,  mobile,  license,  nationalID,  availableSeats);
			            system.addPendingDriver(driver);
			            
			        } else if (registrationChoice == 2) {
			            Customer customer = new Customer();
			            
			            Scanner scann = new Scanner(System.in);
			            
			            System.out.print("Enter Customer Username: ");
			            String username = scann.nextLine();
			            
			            System.out.print("Enter Customer Password: ");
			            String password = scann.nextLine();
			            
			            System.out.print("Enter Customer Mobile: ");
			            String mobile = scann.nextLine();
			            
			            System.out.print("Enter Customer Birthdate ('YYYY-MM-DD'): ");
			            String bithDate = scann.nextLine();
			            
			            customer.register( username,  password,  mobile,  bithDate);
			            system.addUser(customer);
			            menu.displayCustomerMenu(system, customer, admin);
			            
			        } else 
			            System.out.println("invalid choice");
			        
			    }
			    else if (choice == 2){
			    	
			        System.out.print("Enter username: ");
			        String username = scan.next();

			        System.out.print("Enter password: ");
			        String password = scan.next();
			        
			        User user = system.login( username,  password);
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
    
}
