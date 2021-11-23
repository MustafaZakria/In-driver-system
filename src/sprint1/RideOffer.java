/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint1;

/**
 *
 * @author Dell
 */
public class RideOffer {
    Ride ride;

    public RideOffer(Ride ride) {
        this.ride = ride;
        notifyCustomer();
    }
    
    
    public void notifyCustomer(){
        ride.customer.offers.add(ride);
    }

    
    
    
}
