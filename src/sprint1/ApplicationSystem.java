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
public class ApplicationSystem {

    protected ArrayList<User> users;
    protected ArrayList<Driver> pendingDriverList;
    protected ArrayList<Driver> verifiedDrivers;
    protected ArrayList<RideOffer> rideOffers;
    protected ArrayList<Ride> acceptedRides;

    public ApplicationSystem() {
        users = new ArrayList<>();
        pendingDriverList = new ArrayList<>();
        verifiedDrivers = new ArrayList<>();
        rideOffers = new ArrayList<>();
        acceptedRides = new ArrayList<>();
    }

    public User login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void setAllOffers() {
        for (User user : users) {
            if (user.getType() == Type.Customer) {
                Customer customer = (Customer) user;
                for (RideOffer offer : customer.offers) {
                    if (!rideOffers.contains(offer)) {
                        rideOffers.add(offer);
                    }
                }
            }
        }
    }

    public void setAllAcceptedRides() {
        for (User user : users) {
            if (user.getType() == Type.Customer) {
                Customer customer = (Customer) user;
                for (Ride accepted : customer.Rides) {
                    if (!acceptedRides.contains(accepted)) {
                        acceptedRides.add(accepted);
                    }
                }
            }
        }
    }
    
    

    public void addUser(User user) {
        users.add(user);
    }

    public void addPendingDriver(Driver driver) {
        pendingDriverList.add(driver);
    }

    public ArrayList<User> getUsers() {
        System.out.println(users);
        return users;
    }

    public void getVerifiedDrivers() {
        System.out.println(verifiedDrivers);

    }

    public void addVerifiedDriver(Driver driver) {
        verifiedDrivers.add(driver);
    }

    public ArrayList<Driver> getPendingDriverList() {
        System.out.println(pendingDriverList);
        return pendingDriverList;
    }

}
