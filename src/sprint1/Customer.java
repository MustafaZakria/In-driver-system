
package sprint1;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User{
    
    private RideOrganization rideOrg;
    ArrayList<RideOffer> offers;
    protected ArrayList<Ride> Rides;
    
    public Customer(String username, String password, String mobile, Type type) {
        super(username, password, mobile, type);
        offers = new ArrayList<>();
        this.Rides = new ArrayList<>();
    }
    
    public Customer(){
        super();
        offers = new ArrayList<>();
        this.Rides = new ArrayList<>();
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
        this.rideOrg = rideOrg;
        this.rideOrg.matchDrivers(rideOrg.ride, system);
    }


    public ArrayList<RideOffer> getOffers() {
        System.out.println(offers);
        return offers;
    }

    public void setOffers(ArrayList<RideOffer> offers) {
        this.offers = offers;
    }
    
    
    public void acceptRide(Ride ride){
        Rides.add(ride);
        this.offers = null;
        this.offers = new ArrayList<>();
        rideOrg.removeRide(ride);
    }
    
    public void rateDriver(){
        if(!Rides.isEmpty()){
            for(Ride ride : Rides){
                ride.getDriverPrice();
                Driver driver = (Driver) ride.driverPrice.keySet().toArray()[0];
                DriverRating rating = new DriverRating(driver ,this);
                rating.addRating();
                
            }
        }
        else{
            System.out.println("Your Rides are Empty!");
        }
        
    }

    @Override
    public String toString() {
        return "Customer{" + this.username +'}';
    }
    
    
}
