
package sprint1;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Driver extends User{
    
    protected String nationalID;
    protected String license;
    protected boolean verified;
    protected double averageRating;
    protected ArrayList<String> favAreas;
    protected ArrayList<Ride> requestedRides;
    protected ArrayList<Ride> Rides;
    protected HashMap<Customer, Integer> ratings;
    
    public Driver() {
        super();
        this.nationalID = "";
        this.license = "";
        this.averageRating = 0;
        this.verified = false;
        this.favAreas = new ArrayList<>();
        this.requestedRides = new ArrayList<>();
        this.Rides = new ArrayList<>();
        this.ratings = new HashMap<>();
    }
    

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getLicense() {
        return license;
    }

    public boolean isVerified() {
        return verified;
    }
    
    public void addArea(String area){
        favAreas.add(area);
    }
    
    public void updateRides(Ride ride){
        
        requestedRides.add(ride); 
    }
    
    public void getRequestedRides(){
        System.out.println(requestedRides);
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public HashMap<Customer, Integer> getRatings() {
        
        for (Map.Entry<Customer, Integer> entry : ratings.entrySet())
        {
            System.out.println(entry.getKey() + ", Their rating= " + entry.getValue());
        }
        return ratings;
    }

    public void setRatings(HashMap<Customer, Integer> ratings) {
        this.ratings = ratings;
    }
    
    
    
    
    public void suggestPrice(){
        double price;
        Scanner scan = new Scanner(System.in);
        ArrayList<Ride> found = new ArrayList<>();
        for(Ride ride : requestedRides){
            
            System.out.print("Suggest a price from " + ride.source +" to " + ride.destination + ": ");
            price = scan.nextDouble();
            ride.driverPrice.put(this, price);
            RideOffer rideOffer = new RideOffer(ride.source, ride.destination, price, this, ride.customer);
            rideOffer.offerTime = LocalTime.now();
            found.add(ride);
            
        }
        requestedRides.removeAll(found);
        
    }
    
    public void arrived(Ride ride){
        ride.arrivingTime = LocalTime.now();
    }
    
    @Override
    public void register() {
        Scanner input = new Scanner (System.in);
        
        System.out.print("Enter Driver Username: ");
        this.username = input.nextLine();
        
        System.out.print("Enter Driver Password: ");
        this.password = input.nextLine();
        
        System.out.print("Enter Driver Mobile: ");
        this.mobile = input.nextLine();
        
        System.out.print("Enter Driver Licence: ");
        this.license = input.nextLine();
        
        System.out.print("Enter Driver National-ID: ");
        this.nationalID = input.nextLine();
        
        this.suspend = false;
        
        this.verified = false;
        
        this.type = Type.Driver;
    }

    @Override
    public String toString() {
        return "{" + "Name= "+ this.username +", averageRating=" + averageRating + '}';
    }

    
    
    
    
}
