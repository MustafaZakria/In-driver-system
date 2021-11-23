/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint1;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class RideOrganization {
    Ride ride;
    ApplicationSystem system;
    ArrayList <Driver> availableDrivers;
    
    public RideOrganization(Ride ride, ApplicationSystem system) {
        this.ride = ride;
        this.system = system;
        availableDrivers = new ArrayList<>();
        matchDrivers(ride, system);
    }

    public RideOrganization() {
        ride = null;
        system = null;
        availableDrivers = new ArrayList<>();
        
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }
    public void matchDrivers(Ride ride, ApplicationSystem system){
        boolean flag = false;
        for(Driver driver : system.verifiedDrivers){
            for(String area : driver.favAreas)
            {
                if(area.equals(ride.source))
                {
                    availableDrivers.add(driver);
                    notifyDrivers(ride);
                    flag = true;
                    break;
                }
            }
        }
        if(!flag)
            System.out.println("No Available Drivers");
    }
    public void notifyDrivers(Ride ride){
        for(Driver driver : availableDrivers){
            driver.updateRides(ride);
        }
    }
    public void setSystem(ApplicationSystem system) {
        this.system = system;
    }
    
    public void getAvailableDrivers(){
        System.out.print(availableDrivers);
    }
    
    
    
}
