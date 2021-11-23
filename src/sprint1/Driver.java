/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Driver extends User{
    
    protected String nationalID;
    protected String license;
    protected boolean verified;
    protected ArrayList<String> favAreas;
    protected ArrayList<Ride> requestedRides;
    protected ArrayList<Ride> Rides;
    public Driver() {
        super();
        this.nationalID = "";
        this.license = "";
        this.verified = false;
        this.favAreas = new ArrayList<>();
        this.requestedRides = new ArrayList<>();
        this.Rides = new ArrayList<>();
    }
    
   /* public Driver(String username, String password, String mobile, Type type, String nationalID, String license) {
        super(username, password, mobile, type);
        this.license = license;
        this.nationalID = nationalID;
        this.verified = false;
        this.favAreas = new ArrayList<>();
        this.rides = new ArrayList<>();
    }*/
    
    
    
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
        //ride.setDriver(this);  should be after customer accept the driver's offer
        requestedRides.add(ride); 
    }
    
    public void getRequestedRides(){
        System.out.println(requestedRides);
    }
    
    public void suggestPrice(){
        double price;
        Scanner scan = new Scanner(System.in);
        for(Ride ride : requestedRides){
            if(ride.price == 0){
                System.out.print("Suggest a price from " + ride.source +" to " + ride.destination + ": ");
                price = scan.nextDouble();
                ride.setPrice(price);
                RideOffer rideOffer = new RideOffer(ride);
            }
            
        }
        
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
    
}
