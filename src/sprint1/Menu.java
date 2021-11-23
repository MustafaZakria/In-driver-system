package sprint1;

import java.util.Scanner;

public class Menu {
    public void displayCustomerMenu(ApplicationSystem system, Customer customer) {
    	Scanner scan = new Scanner (System.in);
        System.out.println("Welcome: " + customer.getUsername());
    	while(true) {
            System.out.println("1- Request Ride\n2- Get Offers\n3- Exit");
            int customerChoice = scan.nextInt();
            switch(customerChoice){
            
                case 1:
                   System.out.println("Enter Source And Destination");
                   String source = scan.next();
                   String destination = scan.next();
                   customer.requestRide(source, destination, system);
                   break;
                   
                case 2:
                	customer.getOffers();
                   System.out.println("Choose number of offer");
                   int offerChoice = scan.nextInt();
                   customer.offers.get(offerChoice-1).setDriver(customer.offers.get(offerChoice-1).getDriver());
                   customer.Rides.add(customer.offers.get(offerChoice-1));
                   customer.offers.get(offerChoice-1).getDriver().Rides.add(customer.offers.get(offerChoice-1));
                   customer.offers.get(offerChoice-1).getDriver().requestedRides.remove(customer.offers.get(offerChoice-1));
                   break;
                   
                case 3:
                    break;
                    
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
            if(customerChoice==3) break;
    	}

    }
    public void displayDriverMenu(ApplicationSystem system, Driver driver) {
    	Scanner scan = new Scanner (System.in);
    	System.out.println("Welcome: " + driver.getUsername());
    	while(true) {
            System.out.println("1- Add Favorite Areas\n2- Requests rides\n3- Exit");
            int driverChoice = scan.nextInt();
            switch(driverChoice){
                case 1:{
                    String area="";
                    System.out.println("After finishing adding areas enter finish");
                    
                    while(true){
                       area = scan.next();
                       if(area.equals("finish"))
                           break;
                       driver.addArea(area);
                    }
                    break;
                }
                
                case 2: 
                    System.out.println("Driver's rides:");
                    driver.getRequestedRides();
                    driver.suggestPrice();
                    break;
                    
                case 3:
                    break;
               default:
                   System.out.println("Invalid input");
                   break;
                    
            }
            if(driverChoice==3) break;
    	}
    }
    
    public void displayAdminMenu(Admin admin) {
    	Scanner scan = new Scanner (System.in);
    	System.out.println("Welcome Admin");
    	while(true) {           
            System.out.println("1-List All Pending Drivers\n2- Suspend User\n3- Exit");
            
            int adminChoice = scan.nextInt();
           
            if(adminChoice == 1){
            	admin.getPendingDriverList();    
                 System.out.println("1-Verify Drivers\n2- Back");
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
            else break;
    	}
    }
}
