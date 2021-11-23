
package sprint1;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User{
    
    //private RideOrganization rideOrg;
    ArrayList<Ride> offers;
    
    public Customer(String username, String password, String mobile, Type type) {
        super(username, password, mobile, type);
        offers = new ArrayList<>();
    }
    
    public Customer(){
        super();
        offers = new ArrayList<>();
    } 

    @Override
    public void register() {
        Scanner input = new Scanner (System.in);
        System.out.print("Enter Customer Username: ");
        this.username = input.nextLine();
        
        System.out.print("Enter Customer Password: ");
        this.password = input.nextLine();
        
        System.out.print("Enter Customer Mobile: ");
        this.mobile = input.nextLine();
        
        
        this.suspend = false;
        this.type = Type.Customer;
    }
    
    public void requestRide(String source, String destination, ApplicationSystem system){
        RideOrganization rideOrg = new RideOrganization(new Ride(source,destination, this), system);
    }

    public ArrayList<Ride> getOffers() {
        System.out.println(offers);
        return offers;
    }

    public void setOffers(ArrayList<Ride> offers) {
        this.offers = offers;
    }
    
    
    
}
