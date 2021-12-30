package sprint1;

import java.util.Scanner;

public class Menu {

    public void displayCustomerMenu(ApplicationSystem system, Customer customer, Admin admin) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome: " + customer.getUsername());
        while (true) {
            System.out.println("1- Request Ride\n2- Get Offers\n3- Rate Driver\n4-Show Balance\n5- Exit");
            int customerChoice = scan.nextInt();
            switch (customerChoice) {

                case 1:
                    System.out.println("Enter Source And Destination");
                    String source = scan.next();
                    String destination = scan.next();
                    customer.requestRide(source, destination, system);
                    break;

                case 2:

                    customer.getOffers();
                    if (!customer.offers.isEmpty()) {
                        System.out.println("Choose number of offer");
                        int offerChoice = scan.nextInt();
                        Ride ride;
                        
                        ride = new Ride(customer.offers.get(offerChoice - 1).source, customer.offers.get(offerChoice - 1).dest, customer.offers.get(offerChoice - 1).price, customer.offers.get(offerChoice - 1).driver, customer);
                        admin.discounts(ride);
                        
                        customer.offers.get(offerChoice - 1).driver.Rides.add(ride);
                        Driver chosenDriver = customer.offers.get(offerChoice - 1).driver;
                        customer.acceptRide(ride);
                        
                        chosenDriver.arrived(ride);
                        system.setAllAcceptedRides();
                        chosenDriver.rideComplete(ride);
                        

                    } else {
                        System.out.println("There are no offers available");
                    }

                    break;

                case 3:
                    customer.rateDriver();
                    break;
                    
                case 4:
                    System.out.println("Balance: " + customer.getBalance());
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
            if (customerChoice == 5) {
                break;
            }
        }

    }

    public void displayDriverMenu(ApplicationSystem system, Driver driver) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome: " + driver.getUsername());
        while (true) {
            System.out.println("1- Add Favorite Areas\n2- Requested rides\n3- List Your Ratings\n4- Show Balance\n5- Exit");
            int driverChoice = scan.nextInt();
            switch (driverChoice) {
                case 1: {
                    String area;
                    System.out.println("After finishing adding areas enter finish");

                    while (true) {
                        area = scan.next();
                        if (area.equals("finish")) {
                            break;
                        }
                        driver.addArea(area);
                    }
                    break;
                }

                case 2:
                    System.out.println("Driver's rides:");
                    driver.getRequestedRides();
                    driver.suggestPrice();
                    system.setAllOffers();
                    break;

                case 3:
                    if (driver.ratings.isEmpty()) {
                        System.out.println("You have no ratings");
                    } else {
                        driver.getRatings();
                    }
                    break;
                case 4:
                    System.out.println("Balance: " + driver.getBalance());
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid input");
                    break;

            }
            if (driverChoice == 5) {
                break;
            }
        }
    }

    public void displayAdminMenu(Admin admin) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome Admin");
        while (true) {
            System.out.println("1-List All Pending Drivers\n2- Suspend User\n3-Get All Offers\n4-Get All Accepted Rides\n5-Show Arriving To User Location Event\n6-Show Arriving To User Destination Event\n7-Exit");

            int adminChoice = scan.nextInt();

            if (adminChoice == 1) {
                admin.getPendingDriverList();
                System.out.println("1-Verify Drivers\n2- Back");
                int listChoice = scan.nextInt();

                switch (listChoice) {
                    case 1:
                        admin.verify();
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("invaild choice");

                }
            } else if (adminChoice == 2) {
                admin.suspendUser();
            } else if (adminChoice == 3) {
                admin.getAllOffers();
            } else if (adminChoice == 4) {
                admin.getAllAcceptedRides();
            }else if(adminChoice == 5){
                admin.getArrivingEvent();
            } else if(adminChoice == 6){
                admin.getDestinationEvent();
            }
            else {
                break;
            }
        }
    }
}
